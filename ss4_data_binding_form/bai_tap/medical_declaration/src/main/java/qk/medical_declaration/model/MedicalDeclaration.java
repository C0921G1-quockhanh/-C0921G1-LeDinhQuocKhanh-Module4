package qk.medical_declaration.model;

public class MedicalDeclaration {
    protected String fullName;
    protected Integer[] year;
    protected String[] gender;
    protected String[] nationality;
    protected String identityNumber;
    protected String[] transportation;
    protected String vehicleNumber;
    protected String seatNumber;
    protected Integer[] startDay;
    protected Integer[] startMonth;
    protected Integer[] startYear;
    protected Integer[] endDay;
    protected Integer[] endMonth;
    protected Integer[] endYear;
    protected String description;
    protected String[] city;
    protected String[] district;
    protected String[] ward;
    protected String address;
    protected String phoneNumber;
    protected String email;

    protected boolean fever;
    protected boolean noFever;

    protected boolean cough;
    protected boolean noCough;

    protected boolean stuffy;
    protected boolean noStuffy;

    protected boolean soreThroat;
    protected boolean noSoreThroat;

    protected boolean nausea;
    protected boolean noNausea;

    protected boolean diarrhea;
    protected boolean noDiarrhea;

    protected boolean skinHemorrhage;
    protected boolean noSkinHemorrhage;

    protected boolean skinRash;
    protected boolean noSkinRash;

    protected boolean visited;
    protected boolean noVisited;

    protected boolean twoMeters;
    protected boolean noTwoMeters;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName) {
        this.fullName = fullName;
    }

    public MedicalDeclaration(String fullName, Integer[] year) {
        this.fullName = fullName;
        this.year = year;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description, String[] city, String[] district, String[] ward) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description, String[] city, String[] district, String[] ward, String address, String phoneNumber, String email) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description, String[] city, String[] district, String[] ward, String address, String phoneNumber, String email, boolean fever, boolean noFever) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fever = fever;
        this.noFever = noFever;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description, String[] city, String[] district, String[] ward, String address, String phoneNumber, String email, boolean fever, boolean noFever, boolean cough, boolean noCough, boolean stuffy, boolean noStuffy, boolean soreThroat, boolean noSoreThroat, boolean nausea, boolean noNausea, boolean diarrhea, boolean noDiarrhea, boolean skinHemorrhage, boolean noSkinHemorrhage, boolean skinRash, boolean noSkinRash) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fever = fever;
        this.noFever = noFever;
        this.cough = cough;
        this.noCough = noCough;
        this.stuffy = stuffy;
        this.noStuffy = noStuffy;
        this.soreThroat = soreThroat;
        this.noSoreThroat = noSoreThroat;
        this.nausea = nausea;
        this.noNausea = noNausea;
        this.diarrhea = diarrhea;
        this.noDiarrhea = noDiarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.noSkinHemorrhage = noSkinHemorrhage;
        this.skinRash = skinRash;
        this.noSkinRash = noSkinRash;
    }

    public MedicalDeclaration(String fullName, Integer[] year, String[] gender, String[] nationality, String identityNumber, String[] transportation, String vehicleNumber, String seatNumber, Integer[] startDay, Integer[] startMonth, Integer[] startYear, Integer[] endDay, Integer[] endMonth, Integer[] endYear, String description, String[] city, String[] district, String[] ward, String address, String phoneNumber, String email, boolean fever, boolean noFever, boolean cough, boolean noCough, boolean stuffy, boolean noStuffy, boolean soreThroat, boolean noSoreThroat, boolean nausea, boolean noNausea, boolean diarrhea, boolean noDiarrhea, boolean skinHemorrhage, boolean noSkinHemorrhage, boolean skinRash, boolean noSkinRash, boolean visited, boolean noVisited, boolean twoMeters, boolean noTwoMeters) {
        this.fullName = fullName;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.identityNumber = identityNumber;
        this.transportation = transportation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fever = fever;
        this.noFever = noFever;
        this.cough = cough;
        this.noCough = noCough;
        this.stuffy = stuffy;
        this.noStuffy = noStuffy;
        this.soreThroat = soreThroat;
        this.noSoreThroat = noSoreThroat;
        this.nausea = nausea;
        this.noNausea = noNausea;
        this.diarrhea = diarrhea;
        this.noDiarrhea = noDiarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.noSkinHemorrhage = noSkinHemorrhage;
        this.skinRash = skinRash;
        this.noSkinRash = noSkinRash;
        this.visited = visited;
        this.noVisited = noVisited;
        this.twoMeters = twoMeters;
        this.noTwoMeters = noTwoMeters;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer[] getYear() {
        return year;
    }

    public void setYear(Integer[] year) {
        this.year = year;
    }

    public String[] getGender() {
        return gender;
    }

    public void setGender(String[] gender) {
        this.gender = gender;
    }

    public String[] getNationality() {
        return nationality;
    }

    public void setNationality(String[] nationality) {
        this.nationality = nationality;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String[] getTransportation() {
        return transportation;
    }

    public void setTransportation(String[] transportation) {
        this.transportation = transportation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer[] getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer[] startDay) {
        this.startDay = startDay;
    }

    public Integer[] getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer[] startMonth) {
        this.startMonth = startMonth;
    }

    public Integer[] getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer[] startYear) {
        this.startYear = startYear;
    }

    public Integer[] getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer[] endDay) {
        this.endDay = endDay;
    }

    public Integer[] getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer[] endMonth) {
        this.endMonth = endMonth;
    }

    public Integer[] getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer[] endYear) {
        this.endYear = endYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    public String[] getDistrict() {
        return district;
    }

    public void setDistrict(String[] district) {
        this.district = district;
    }

    public String[] getWard() {
        return ward;
    }

    public void setWard(String[] ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isNoFever() {
        return noFever;
    }

    public void setNoFever(boolean noFever) {
        this.noFever = noFever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isNoCough() {
        return noCough;
    }

    public void setNoCough(boolean noCough) {
        this.noCough = noCough;
    }

    public boolean isStuffy() {
        return stuffy;
    }

    public void setStuffy(boolean stuffy) {
        this.stuffy = stuffy;
    }

    public boolean isNoStuffy() {
        return noStuffy;
    }

    public void setNoStuffy(boolean noStuffy) {
        this.noStuffy = noStuffy;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNoSoreThroat() {
        return noSoreThroat;
    }

    public void setNoSoreThroat(boolean noSoreThroat) {
        this.noSoreThroat = noSoreThroat;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isNoNausea() {
        return noNausea;
    }

    public void setNoNausea(boolean noNausea) {
        this.noNausea = noNausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isNoDiarrhea() {
        return noDiarrhea;
    }

    public void setNoDiarrhea(boolean noDiarrhea) {
        this.noDiarrhea = noDiarrhea;
    }

    public boolean isSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(boolean skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public boolean isNoSkinHemorrhage() {
        return noSkinHemorrhage;
    }

    public void setNoSkinHemorrhage(boolean noSkinHemorrhage) {
        this.noSkinHemorrhage = noSkinHemorrhage;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isNoSkinRash() {
        return noSkinRash;
    }

    public void setNoSkinRash(boolean noSkinRash) {
        this.noSkinRash = noSkinRash;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isNoVisited() {
        return noVisited;
    }

    public void setNoVisited(boolean noVisited) {
        this.noVisited = noVisited;
    }

    public boolean isTwoMeters() {
        return twoMeters;
    }

    public void setTwoMeters(boolean twoMeters) {
        this.twoMeters = twoMeters;
    }

    public boolean isNoTwoMeters() {
        return noTwoMeters;
    }

    public void setNoTwoMeters(boolean noTwoMeters) {
        this.noTwoMeters = noTwoMeters;
    }
}
