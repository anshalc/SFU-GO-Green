package com.example.sfugogreenf;

public class getMapImages {

    public int helper = 0;

    //to store images of the map
    public int[] drawable;

    //list of possible locations at SFU
    public String location[] = {"McTaggert Cowan Halls", "Academic Quadrangle",
            "Alcan Aquatic Research Centre, Animal Care Facility",
            "Applied Science Building"};


    //input of images of the map
    public int[][] images = {{
            R.drawable.z_residence_mctaggert_cowan_hall_1000_level_keyplan_layout1_pdf_1,
            R.drawable.z_residence_mctaggert_cowan_hall_2000_level_keyplan_layout1_pdf_1,
            R.drawable.z_residence_mctaggert_cowan_hall_3000_level_keyplan_layout1_pdf_1,
            R.drawable.mctaggertcowanhall4000level}, {
            R.drawable.academic_quadrangle_1000_level_keyplan_pdf_1,
            R.drawable.academic_quadrangle_2000_level_keyplan_layout1_pdf_1,
            R.drawable.academic_quadrangle_3000_level_keyplan_layout1_pdf_1,
            R.drawable.academic_quadrangle_4000_level_keyplan_layout1_pdf_1,
            R.drawable.academic_quadrangle_5000_level_keyplan_layout1_pdf_1,
            R.drawable.academic_quadrangle_6000_level_keyplan_layout1_pdf_1}, {
            R.drawable.alcan_aquatic_research_centre_keyplan_layout1_pdf_1}, {
            R.drawable.animal_care_facility_keyplan_layout1_pdf_1}, {
            R.drawable.applied_science_building_01_8000_level_keyplan_layout1_pdf_1,
            R.drawable.applied_science_building_02_9000_level_keyplan_layout1_pdf_1,
            R.drawable.applied_science_building_03_10000_level_keyplan_layout1_pdf_1
    }};

    //constructor assigns images shortlisted by the location to the array drawable
    public getMapImages(String ln) {
        for (int i = 0; i < location.length; i++) {
            if (ln.contains(location[i])) {
                helper = i;
            }
        }

        drawable = new int[images[helper].length];
        for (int j = 0; j < drawable.length; j++) {
            drawable[j] = images[helper][j];
        }
    }
}

