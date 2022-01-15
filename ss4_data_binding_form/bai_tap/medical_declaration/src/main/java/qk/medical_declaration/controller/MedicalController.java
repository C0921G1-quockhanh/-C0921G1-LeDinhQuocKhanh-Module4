package qk.medical_declaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qk.medical_declaration.model.MedicalDeclaration;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MedicalController {

    @GetMapping(value = "/home")
    public String medicalHome(Model model) {

        List<Integer> years = new ArrayList<>();
        for (int year = 1970; year <= 2021; year++) {
            years.add(year);
        }
        model.addAttribute("years",years);

        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        model.addAttribute("genders",genders);

        List<String> nationalities = new ArrayList<>();
        nationalities.add("Viet Nam");
        nationalities.add("USA");
        nationalities.add("Korea");
        nationalities.add("Hong Kong");
        nationalities.add("China");
        nationalities.add("Singapore");
        nationalities.add("UK");
        nationalities.add("Canada");
        nationalities.add("France");
        model.addAttribute("nationalities",nationalities);

        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
        model.addAttribute("medicalDeclaration",medicalDeclaration);

        List<String> typeOfTransportation = new ArrayList<>();
        typeOfTransportation.add("Planes");
        typeOfTransportation.add("Ships");
        typeOfTransportation.add("Cars");
        typeOfTransportation.add("Others (Specific)");
        model.addAttribute("typeOfTransportation",typeOfTransportation);

        List<Integer> days = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            days.add(day);
        }
        model.addAttribute("days",days);

        List<Integer> months = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            months.add(month);
        }
        model.addAttribute("months",months);

        List<String> cities = new ArrayList<>();
        cities.add("Da Nang");
        cities.add("Sai Gon");
        cities.add("Ha Noi");
        cities.add("Hai Phong");
        model.addAttribute("cities",cities);

        List<String> districts = new ArrayList<>();
        districts.add("Thanh Khe");
        districts.add("Hai Chau");
        districts.add("Hoa Vang");
        districts.add("Cam Le");
        districts.add("Ngu Hanh Son");
        model.addAttribute("districts",districts);

        List<String> wards = new ArrayList<>();
        wards.add("Hoa Khe");
        wards.add("Thanh Khe Dong");
        wards.add("Thanh Khe Tay");
        model.addAttribute("wards",wards);

        return "home";
    }

    @PostMapping(value = "/currentForm")
    public String checkCurrentForm(@ModelAttribute(name = "medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model) {
        List<Integer> years = new ArrayList<>();
        for (int year = 1970; year <= 2021; year++) {
            years.add(year);
        }
        model.addAttribute("years",years);

        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        model.addAttribute("genders",genders);

        List<String> nationalities = new ArrayList<>();
        nationalities.add("Viet Nam");
        nationalities.add("USA");
        nationalities.add("Korea");
        nationalities.add("Hong Kong");
        nationalities.add("China");
        nationalities.add("Singapore");
        nationalities.add("UK");
        nationalities.add("Canada");
        nationalities.add("France");
        model.addAttribute("nationalities",nationalities);

//        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
//        model.addAttribute("medicalDeclaration",medicalDeclaration);

        List<String> typeOfTransportation = new ArrayList<>();
        typeOfTransportation.add("Planes");
        typeOfTransportation.add("Ships");
        typeOfTransportation.add("Cars");
        typeOfTransportation.add("Others (Specific)");
        model.addAttribute("typeOfTransportation",typeOfTransportation);

        List<Integer> days = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            days.add(day);
        }
        model.addAttribute("days",days);

        List<Integer> months = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            months.add(month);
        }
        model.addAttribute("months",months);

        List<String> cities = new ArrayList<>();
        cities.add("Da Nang");
        cities.add("Sai Gon");
        cities.add("Ha Noi");
        cities.add("Hai Phong");
        model.addAttribute("cities",cities);

        List<String> districts = new ArrayList<>();
        districts.add("Thanh Khe");
        districts.add("Hai Chau");
        districts.add("Hoa Vang");
        districts.add("Cam Le");
        districts.add("Ngu Hanh Son");
        model.addAttribute("districts",districts);

        List<String> wards = new ArrayList<>();
        wards.add("Hoa Khe");
        wards.add("Thanh Khe Dong");
        wards.add("Thanh Khe Tay");
        model.addAttribute("wards",wards);

        model.addAttribute("medicalDeclaration",medicalDeclaration);

        return "current_form";
    }

    @PostMapping(value = "/updateForm")
    public String checkUpdateForm(@ModelAttribute(name = "medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model, @RequestParam(name = "Confirm") String confirm) {
        if (confirm.equals("Update_Declaration")) {
            List<Integer> years = new ArrayList<>();
            for (int year = 1970; year <= 2021; year++) {
                years.add(year);
            }
            model.addAttribute("years",years);

            List<String> genders = new ArrayList<>();
            genders.add("Male");
            genders.add("Female");
            model.addAttribute("genders",genders);

            List<String> nationalities = new ArrayList<>();
            nationalities.add("Viet Nam");
            nationalities.add("USA");
            nationalities.add("Korea");
            nationalities.add("Hong Kong");
            nationalities.add("China");
            nationalities.add("Singapore");
            nationalities.add("UK");
            nationalities.add("Canada");
            nationalities.add("France");
            model.addAttribute("nationalities",nationalities);

            List<String> typeOfTransportation = new ArrayList<>();
            typeOfTransportation.add("Planes");
            typeOfTransportation.add("Ships");
            typeOfTransportation.add("Cars");
            typeOfTransportation.add("Others (Specific)");
            model.addAttribute("typeOfTransportation",typeOfTransportation);

            List<Integer> days = new ArrayList<>();
            for (int day = 1; day <= 31; day++) {
                days.add(day);
            }
            model.addAttribute("days",days);

            List<Integer> months = new ArrayList<>();
            for (int month = 1; month <= 12; month++) {
                months.add(month);
            }
            model.addAttribute("months",months);

            List<String> cities = new ArrayList<>();
            cities.add("Da Nang");
            cities.add("Sai Gon");
            cities.add("Ha Noi");
            cities.add("Hai Phong");
            model.addAttribute("cities",cities);

            List<String> districts = new ArrayList<>();
            districts.add("Thanh Khe");
            districts.add("Hai Chau");
            districts.add("Hoa Vang");
            districts.add("Cam Le");
            districts.add("Ngu Hanh Son");
            model.addAttribute("districts",districts);

            List<String> wards = new ArrayList<>();
            wards.add("Hoa Khe");
            wards.add("Thanh Khe Dong");
            wards.add("Thanh Khe Tay");
            model.addAttribute("wards",wards);

            model.addAttribute("medicalDeclaration",medicalDeclaration);
            model.addAttribute("msgUpdate","Updated Successfully!");

            return "update_form";
        }

        if (confirm.equals("Cancel")) {
            model.addAttribute("msgNotUpdate","Updated Unsuccessfully!");
            return "no_update_form";
        }

        return "";
    }
}
