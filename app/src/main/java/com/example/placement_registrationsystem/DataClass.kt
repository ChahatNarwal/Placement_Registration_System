package com.example.placement_registrationsystem

class DataClass {
    var FirstName: String? = null
    var LastName:String? = null
    var registerEmail:String? = null
    var ContactNo:String? = null
    var Degree:String? = null
    var Specialization:String? = null
    var currentCgpa:String? = null
    var Address:String? = null
    var profileImage: String? = null

    constructor(FirstName: String?,
                LastName:String?,
                registerEmail:String?,
                ContactNo:String?,
                Degree:String?,
                Specialization:String?,
                currentCgpa:String?,
                Address:String?,
                profileImage: String?) {
        this.FirstName = FirstName
        this.LastName = LastName
        this.registerEmail = registerEmail
        this.ContactNo = ContactNo
        this.Degree = Degree
        this.Specialization = Specialization
        this.currentCgpa = currentCgpa
        this.Address = Address
        this.profileImage = profileImage
    }
    constructor() {}




}