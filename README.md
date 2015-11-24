JSON Parcelable
===
This simple library provides basic parcelization functionality on pojo objects.
Serialization to parcel, bases on Json serialization (thanks to Jackson Serializer):

Writing to parcel works in two main steps:
* Object is serialized to json string
* json string is written to parcel

It isn't as fast as standard method but is fast enough for today's smartphones. End-user will not notice any difference.

Usage is simple as possible. 
Any thing what you need to do, is extend JsonParcelable class in your pojo object and provide blank constructor without parameters, look at example above.

```Java
public class SimplePojo extends JsonParcelable {
  private int integer;
  private boolean bool;
  private String string;
  private ArrayList<String> strings;
  
  public SimplePojo() {
  }
  
  public SimplePojo(int integer, boolean bool, String string, ArrayList<String> strings) {
    this.integer = integer;
    this.bool = bool;
    this.string = string;
    this.strings = strings;
  }
  
  public int getInteger() {
    return integer;
  }
  ...
}
```

Usage examples
---

* write to Bundle
```Java 
simplePojo.putJsonParcelable(bundle) ;
```
* or Intent
```Java
simplePojo.putJsonParcelable(intent);
```
* read from bundle
```Java
simplePojo = JsonParcelable.GetJsonParcelable(SimplePojo.class, bundle);
```
* Because serialization is based on json you can serialize object to json string
```Java
simplePojo.serialize();
```
* inflate existing object
```Java
simplePojo.inflate(jsonString);
```
* or create new from jsonString
```Java
simplePojo = JsonParcelable.Deserialize(SimplePojo.class, jsonString);
```

Android Studio hint
---
If you work with AndroidStudio you should disable lint inspection for missing CREATOR in classes that implements Parcelable.
JsonParcelable class already provide CREATOR and you shouldn't care about it.

License
-------

    Copyright 2015 Jan Góral

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
