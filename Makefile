JAVA_HOME := $(GRAALVM_HOME)
PATH := $(GRAALVM_HOME)/bin:$(shell echo $$PATH)
LLVM_TOOLCHAIN := $(shell $(GRAALVM_HOME)/bin/lli --print-toolchain-path)
UNAME := $(shell uname)

ifeq ($(UNAME), Linux)
	OSFLAG = +linux
endif

ifeq ($(UNAME), Darwin)
	OSFLAG = +macos
endif

clean:
	-rm sdl_example
	-rm -r src/bindings
	-rm -r target
	-rm -r libs/*

info:
	native-image --expert-options-all

sdl-bindings:
	LLVM_TOOLCHAIN=${LLVM_TOOLCHAIN} lein exec -ep "(require '[clobits.examples.sdl.create-sdl-lib]) (clobits.examples.sdl.create-sdl-lib/-main)"
	-rm -r target

ncurses-bindings:
	LLVM_TOOLCHAIN=${LLVM_TOOLCHAIN} lein exec -ep "(require '[clobits.examples.ncurses.create-ncurses-lib]) (clobits.examples.ncurses.create-ncurses-lib/-main)"
	-rm -r target

bindings: assert-graal assert-clang sdl-bindings ncurses-bindings

sdl-poly: bindings
	lein with-profiles $(OSFLAG),+sdl-poly do clean, run

ncurses-poly: bindings
	lein with-profiles $(OSFLAG),+ncurses-poly do clean, run

sdl-ni: bindings
	NATIVE_IMAGE=true NI_EXAMPLE=sdl ./compile && LD_LIBRARY_PATH=./libs ./sdl_example

ncurses-ni: bindings
	NATIVE_IMAGE=true NI_EXAMPLE=ncurses ./compile && LD_LIBRARY_PATH=./libs ./ncurses_example

assert-graal:
	@ if [ "${GRAALVM_HOME}" = "" ]; then \
		echo "\n  Error: You must set or pass in the GRAALVM_HOME environment variable.\n"; \
		exit 1; \
	fi

assert-clang:
	${LLVM_TOOLCHAIN}/clang --version
