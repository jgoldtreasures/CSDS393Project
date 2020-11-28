public class ScreenDescriptions extends GameScreen{
    public static String description;

   public String returnDesc(){
       buildingDescription();
       return buildingName;
   }

    public void buildingDescription() {
        switch (buildingName) {
            case ("Bingham"): //civil and environmental engineering, sleeping/studying
                description = "";
            case ("Carlton"):
                description = "";
            case ("Crawford"): //Access Services, SAGES office, a cafe, childhood,
                // social justice institute,cognitive science studies,
                description = "";
            case ("Dennys"):
                description = "";
            case ("Eldred"): //department of theater
                description = "";
            case ("Freshman Dorms"):
                description = "";
            case ("Glennan"): //electrical, computer and systems engineering, csds,
                // meche and aerospace,
                description = "";
            case ("KSL"):
                description = "This is the main library on CWRU's campus. This location" +
                        " offers individual and group study spaces, as well as a cafe. " +
                        "You may also access a large quantity of resources through the " +
                        "library's website. The physical location also offers " +
                        "digital/multimedia services " +
                        "such as sound editing, audio/video digitizing, and " +
                        "rentable electronic devices.";
            case ("KHS"): //macromolecular science and engineering
                description = "";
            case ("Leutner"):
                description = "";
            case ("Millis"): //Connected to Clapp where the department of Chemistry is
                description = "";
            case ("Nord"): //computer lab, engineering leadership and professional
                // practice, general engineering, peer advisors
                description = "";
            case ("Olin"):
                description = "";
            case ("PBL"):
                description = "All business related majors can be found within this " +
                        "building.";
            case ("Rockefeller"): //physics, evolutionary biology
                description = "";
            case ("Sears"): //multicultural affairs, career center, disability resources,
                // educational services(mentoring/tutoring), study center, SOURCE
                // office, counseling services, department of astronomy
                description = "";
            case ("Smith"): //department of chemical and biomolecular engineering,
                // environmental studies program, earth environmental and planetary
                // sciences, natural sciences
                description = "";
            case ("Sophomore Dorms"):
                description = "";
            case ("Strosacker"): //largest lecture hall on campus AND it has a room
                // upstiars where you can sit an study
                description = "";
            case ("Thwing"): //postal substation, residence life, university housing,
                // jolly scholar
                description = "";
            case ("Tink"): //public sevice, commuter services, women's center, greek
                // life, lgbt, student activities and leadership,
                description = "";
            case ("Tomlinson"): //international affairs, international student
                // services, religious studies
                description = "";
            case ("Veale"):
                description = "This is CWRU's main GYM. This is the main location for " +
                        "most of our varsity and intramural sports, it also has a " +
                        "cardio workout room, a weight room, an open-access pool, " +
                        "basketball, racquetball, a rockwall, and an indoor track. " +
                        "Veale is also connected to our maker-space, and club meeting " +
                        "location, ThinkBox.";
            case ("White"): //materials science and engineering
                description = "";
            case ("Wickenden"): //biomedical engineering
                description = "";
            case ("Yost"): //financial aid, student employment, student financial
                // services, mathematics and statistics department
                description = "";
            default:
                description = "";
        }
    }
}
