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

cp_info {
  // TODO
}

field_info {
  // TODO
}

method_info {
  // TODO
}