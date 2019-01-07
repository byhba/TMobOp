package com.mprof.com

object  UserTable {

    val TABLE_NAME = "users"
    val COLUMN_ID = "user_id"
    val COLUMN_NAME = "name"
    val COLUMN_FNAME = "fname"
    val COLUMN_ADDRESS = "user_address"
    val COLUMN_EMAIL ="email"
    val COLUMN_TEL = "tel"
    val COLUMN_PASS = "pass"
    val COLUMN_ROLE = "role"
    val COLUMN_FIELD ="discipline"
    val COLUMN_LEVEL = "level"
    val COLUMN_BIRTH = "birthdate"
    val COLUMN_REGISTERDATE = "registeredAt"


}
object RoleTable{
    val TABLE_NAME = "roles"
    val COLUMN_ID = "role_id"
    val COLUMN_NAME = "role_name"
    val COLUMN_DESC = "description"
}
//discipline
object FieldTable{
    val TABLE_NAME = "Discipline"
    val COLUMN_ID = "id"
    val COLUMN_NAME = "name_field"
    val COLUMN_DESC = "description"
}

object AddressTable{
    val TABLE_NAME = "adress"
    val COLUMN_ID ="adress_id"
    val COLUMN_NAME="street_name"
    val COLUMN_NUMBER ="street_nb"
    val COLUMN_ZIP ="COLUMN_NUMBER"
    val COLUMN_CITY = "city"
    val COLUMN_CANTON ="canton"
    val COLUMN_COUNTRY =    "country"

}
object DemandTable{
    val TABLE_NAME = "demand"
    val COLUMN_ID = "id"
    val COLUMN_STUDENT = "student"
    val COLUMN_POSTEDAT = "postedAt"
    val COLUMMN_MESG ="message"
    val COLUMN_STATUS = "status"
}

object OfferTable{
    val TABLE_NAME = "offer"
    val COLUMN_ID= "id"
    val COLUMN_PROF = "prof"
    val COLUMN_COURSE_TYPE = "course_type"
    val COLUMN_AVAILABLE ="availability"
    val COLUMN_POSTEDAT = "postedAt"
    val COLUMN_MSG = "message"
    val COLUMN_ACTIVE ="isActive"
}
object StatusTable{
    val COLUMN_ID = "id"
    val COLUMN_LABEL ="label"
    val COLUMN_DESC = "description"
}

object TypeCourseTable{
    val TABLE_NAME = "course"
    val COLUMN_ID = "type_id"
    val COLUMN_LABEL ="name"
    val COLUMN_DESC = "description"
}