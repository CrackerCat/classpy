/*
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
*/
ClassFile {
  magic:         u4
  minor_version: u2
  major_version: u2
  constant_pool: table<cp_info>
  access_flags:  u2
  this_class:    u2
  super_class:   u2
  interfaces:    table<u2>
  fields:        table<field_info>
  methods:       table<method_info>
  attributes:    table<u2>
}

cp_info:tag<u1> {
   1 -> CONSTANT_Utf8
   3 -> CONSTANT_Integer
   4 -> CONSTANT_Float
   5 -> CONSTANT_Long
   6 -> CONSTANT_Double
   7 -> CONSTANT_Class
   8 -> CONSTANT_String
   9 -> CONSTANT_Fieldref
  10 -> CONSTANT_Methodref
  11 -> CONSTANT_InterfaceMethodref
  12 -> CONSTANT_NameAndType
  15 -> CONSTANT_MethodHandle
  16 -> CONSTANT_MethodType
  17 -> CONSTANT_Dynamic
  18 -> CONSTANT_InvokeDynamic
  19 -> CONSTANT_Module
  20 -> CONSTANT_Package
}

field_info {
  // TODO
}

method_info {
  // TODO
}