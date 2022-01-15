<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 1/15/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Current_Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
        textarea{
            width: 100%;
        }
    </style>
</head>
<body>

    <form:form method="post" action="/updateForm" modelAttribute="medicalDeclaration">

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <h4 class="text-center">MEDICAL DECLARATION</h4>
                    <h5 class="text-center">This is an important document, your information will help health authorities contact when necessary to prevent infectious diseases</h5>
                    <p class="text-center text-danger fw-bold">Warning: Declaring false information is a violation of Vietnamese law and can be criminally handled</p>
                </div>
            </div>

        </div>

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <p class="form-label fw-bold">FULL NAME: (UPPERCASE) <span class="text-danger">(*)</span> </p>
                    <form:input path="fullName" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">YEAR: <span class="text-danger">(*)</span> </p>
                            <form:select path="year" multiple="false">
                                <form:option value="-1">-Choose-</form:option>
                                <form:options items="${years}"/>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">GENDER: <span class="text-danger">(*)</span> </p>
                            <form:select path="gender" multiple="false">
                                <form:option value="NONE">-Choose-</form:option>
                                <form:options items="${genders}"/>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">NATIONALITY: <span class="text-danger">(*)</span> </p>
                            <form:select path="nationality" multiple="false">
                                <form:option value="NONE">-Choose-</form:option>
                                <form:options items="${nationalities}"/>
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <p class="form-label fw-bold">IDENTITY NUMBER: <span class="text-danger">(*)</span> </p>
                    <form:input path="identityNumber" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <p class="form-label fw-bold">TRANSPORTATION INFORMATION: <span class="text-danger">(*)</span> </p>
                    <form:radiobuttons path="transportation" items="${typeOfTransportation}" cssClass="ms-3"/>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">VEHICLE NUMBER: </p>
                            <form:input path="vehicleNumber" cssClass="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">SEAT NUMBER: </p>
                            <form:input path="seatNumber" cssClass="form-control"/>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <div class="col-xl-6">
                    <div class="row">

                        <p class="form-label fw-bold">START DAY: <span class="text-danger">(*)</span></p>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="startDay" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${days}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="startMonth" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${months}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="startYear" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${years}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-6">
                    <div class="row">

                        <p class="form-label fw-bold">END DAY: <span class="text-danger">(*)</span></p>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="endDay" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${days}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="endMonth" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${months}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-4">
                            <div class="row">
                                <div class="col-xl-12">
                                    <form:select path="endYear" multiple="false">
                                        <form:option value="-1">-Choose-</form:option>
                                        <form:options items="${years}"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <p class="form-label fw-bold">DESCRIPTION IN THE PAST 14 DAYS: <span class="text-danger">(*)</span> </p>
                    <form:textarea path="description" rows="5"/>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <p class="form-label fw-bold">CONTACT ADDRESS: </p>

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">CITIES: <span class="text-danger">(*)</span> </p>
                            <form:select path="city" multiple="false">
                                <form:option value="NONE">-Choose-</form:option>
                                <form:options items="${cities}"/>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">DISTRICTS: <span class="text-danger">(*)</span> </p>
                            <form:select path="district" multiple="false">
                                <form:option value="NONE">-Choose-</form:option>
                                <form:options items="${districts}"/>
                            </form:select>
                        </div>
                    </div>
                </div>

                <div class="col-xl-4">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">WARDS: <span class="text-danger">(*)</span> </p>
                            <form:select path="ward" multiple="false">
                                <form:option value="NONE">-Choose-</form:option>
                                <form:options items="${wards}"/>
                            </form:select>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">
                <div class="col-xl-12">
                    <p class="form-label fw-bold">ADDRESS: <span class="text-danger">(*)</span> </p>
                    <form:input path="address" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">PHONE NUMBER: <span class="text-danger">(*)</span> </p>
                            <form:input path="phoneNumber" cssClass="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <p class="form-label fw-bold">EMAIL: </p>
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="mt-3 mx-3">
            <div class="row">

                <p class="form-label fw-bold">IN THE PAST 14 DAYS, HAVE YOU EXPERIENCED ANY OF THE FOLLOWING SYMPTOMS? <span class="text-danger">(*)</span></p>

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <table class="table">
                                <thead class="bg-secondary">
                                <tr>
                                    <th scope="col">SYMPTOMS</th>
                                    <th scope="col">YES</th>
                                    <th scope="col">NO</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr>
                                    <td class="fw-bold">FEVER <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="fever" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noFever" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">COUGH <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="cough" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noCough" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">STUFFY <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="stuffy" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noStuffy" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">SORE THROAT <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="soreThroat" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noSoreThroat" value="true"/>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-xl-6">
                    <div class="row">
                        <div class="col-xl-12">
                            <table class="table">
                                <thead class="bg-secondary">
                                <tr>
                                    <th scope="col">SYMPTOMS</th>
                                    <th scope="col">YES</th>
                                    <th scope="col">NO</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr>
                                    <td class="fw-bold">NAUSEA <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="nausea" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noNausea" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">DIARRHEA <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="diarrhea" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noDiarrhea" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">SKIN HEMORRHAGE <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="skinHemorrhage" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noSkinHemorrhage" value="true"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="fw-bold">SKIN RASH <span class="text-danger">(*)</span></td>
                                    <td>
                                        <form:checkbox path="skinRash" value="true"/>
                                    </td>
                                    <td>
                                        <form:checkbox path="noSkinRash" value="true"/>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="mt-3 mx-3">

            <p class="form-label fw-bold">EXPOSURE HISTORY: IN THE PAST 14 DAYS, HAVE YOU HAD? <span class="text-danger">(*)</span></p>

            <div class="row">
                <div class="col-xl-12">
                    <table class="table">
                        <thead class="bg-secondary">
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">YES</th>
                            <th scope="col">NO</th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td class="fw-bold">GO TO A FARM / LIVE ANIMAL MARKET / ANIMAL SLAUGHTERHOUSE / ANIMAL CONTACT <span class="text-danger">(*)</span></td>
                            <td>
                                <form:checkbox path="visited" value="true"/>
                            </td>
                            <td>
                                <form:checkbox path="noVisited" value="true"/>
                            </td>
                        </tr>

                        <tr>
                            <td class="fw-bold">CLOSE CONTACT (<2 METERS) WITH PEOPLE WHO HAVE RESPIRATORY INFECTIONS CAUSED BY NCoV? <span class="text-danger">(*)</span></td>
                            <td>
                                <form:checkbox path="twoMeters" value="true"/>
                            </td>
                            <td>
                                <form:checkbox path="noTwoMeters" value="true"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <div class="mt-3 mx-3">
            <input type="submit" value="Update_Declaration" class="bg-warning rounded-pill text-center" name="Confirm">
            <input type="submit" value="Cancel" class="rounded-pill text-center" name="Confirm">
        </div>


    </form:form>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
