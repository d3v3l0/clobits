// This file is autogenerated -- probably shouldn't modify it by hand

package bindings.sdl_ni_generated;

import bindings.sdl_structs.ISDL_Event;
import clobits.all_targets.IWrapperNI;

public class WrapSDL_Event implements ISDL_Event, IWrapperNI {
  SDL_Event pointer;

  // used when sending data to native functions
  public SDL_Event unwrap() {
    return this.pointer;
  }

  public int type() {
    return this.pointer.type();
  }

  public bindings.sdl_ni_generated.WrapSDL_KeyboardEvent key() {
    return new bindings.sdl_ni_generated.WrapSDL_KeyboardEvent(this.pointer.key());
  }

  public void set_type(int v) {
    this.pointer.set_type(v);
  }

  public void set_key(bindings.sdl_ni_generated.WrapSDL_KeyboardEvent v) {
    this.pointer.set_key(v.unwrap());
  }

  public void set_key(bindings.sdl_structs.ISDL_KeyboardEvent v) {
    this.pointer.set_key(v);
  }

  public WrapSDL_Event(SDL_Event pointer) {
    this.pointer = pointer;
  }
}
