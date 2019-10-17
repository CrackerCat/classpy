ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1]; // TODO
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

cp_info = u1:{
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

CONSTANT_Utf8_info {
    u1 tag;
    u2 length;
    u1 bytes[length];
}
CONSTANT_Integer_info {
    u1 tag;
    u4 bytes;
}
CONSTANT_Float_info {
    u1 tag;
    u4 bytes;
}
CONSTANT_Long_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
}
CONSTANT_Double_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
}
CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
}
CONSTANT_String_info {
    u1 tag;
    u2 string_index;
}
CONSTANT_Fieldref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
CONSTANT_InterfaceMethodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
CONSTANT_NameAndType_info {
    u1 tag;
    u2 name_index;
    u2 descriptor_index;
}
CONSTANT_MethodHandle_info {
    u1 tag;
    u1 reference_kind;
    u2 reference_index;
}
CONSTANT_MethodType_info {
    u1 tag;
    u2 descriptor_index;
}
CONSTANT_Dynamic_info {
    u1 tag;
    u2 bootstrap_method_attr_index;
    u2 name_and_type_index;
}
CONSTANT_InvokeDynamic_info {
    u1 tag;
    u2 bootstrap_method_attr_index;
    u2 name_and_type_index;
}
CONSTANT_Module_info {
    u1 tag;
    u2 name_index;
}
CONSTANT_Package_info {
    u1 tag;
    u2 name_index;
}

field_info {
  // TODO
}

method_info {
  // TODO
}