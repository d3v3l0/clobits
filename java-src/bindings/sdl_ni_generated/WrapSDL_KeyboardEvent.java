// This file is autogenerated -- probably shouldn't modify it by hand

package bindings.sdl_ni_generated;

import bindings.sdl_structs.ISDL_KeyboardEvent;
import clobits.all_targets.IWrapperNI;

public class WrapSDL_KeyboardEvent implements ISDL_KeyboardEvent, IWrapperNI {
  SDL_KeyboardEvent pointer;

  // used when sending data to native functions
  public SDL_KeyboardEvent unwrap() {
    return this.pointer;
  }

  public bindings.sdl_ni_generated.WrapSDL_Keysym keysym() {
    return new bindings.sdl_ni_generated.WrapSDL_Keysym(this.pointer.keysym());
  }

  public void set_keysym(bindings.sdl_ni_generated.WrapSDL_Keysym v) {
    this.pointer.set_keysym(v.unwrap());
  }

  public void set_keysym(bindings.sdl_structs.ISDL_Keysym v) {
    this.pointer.set_keysym(v);
  }

  public WrapSDL_KeyboardEvent(SDL_KeyboardEvent pointer) {
    this.pointer = pointer;
  }
}
