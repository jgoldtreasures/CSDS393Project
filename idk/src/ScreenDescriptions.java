public class ScreenDescriptions{
    private String description;
    private String buildingName;

    public ScreenDescriptions(String roomName){
        buildingName = roomName;
    }

    public String returnDesc(){
        buildingDescription(buildingName);
        return description;
    }

    public void buildingDescription(String buildingName) {
        switch (buildingName) {
            case ("Bingham"): //civil and environmental engineering, sleeping/studying
                description = "Sleep";
                break;
            case ("Carlton"):
                description = "";
                break;
            case ("Crawford"): //Access Services, SAGES office, a cafe, childhood,
                // social justice institute,cognitive science studies,
                description = "";
                break;
            case ("Dennys"):
                description = "";
                break;
            case ("Eldred"): //department of theater
                description = "";
                break;
            case ("Freshman Dorms"):
                description = "Includes buildings such as Taplin, Taft, Smith, " +
                            "Raymond, Sherman, Tyler, Norton, Storrs, Pierce, " +
                            "Hitchock, Cutler, Clark Tower, and Cutter";
                break;
            case ("Glennan"): //electrical, computer and systems engineering, csds,
                // meche and aerospace,
                description = "This building has the main offices of the electrical, " +
                        "computer and systems engineering, computer and data science, " +
                        "mechanical engineering, and aerospace engineering departments," +
                        "as well as some classrooms and labs.";
                break;
            case ("KSL"):
                description = "This is the main library on CWRU's campus. This location" +
                        " offers individual and group study spaces, as well as a cafe. " +
                        "You may also access a large quantity of resources through the " +
                        "library's website. The physical location also offers " +
                        "digital/multimedia services " +
                        "such as sound editing, audio/video digitizing, and " +
                        "rentable electronic devices.";
                break;
            case ("KHS"): //macromolecular science and engineering
                description = "";
                break;
            case ("Leutner"):
                description = "";
                break;
            case ("Millis"): //Connected to Clapp where the department of Chemistry is
                description = "";
                break;
            case ("Nord"): //computer lab, engineering leadership and professional
                // practice, general engineering, peer advisors
                description = "";
                break;
            case ("Olin"):
                description = "";
                break;
            case ("PBL"):
                description = "All business related majors can be found within this " +
                        "building.";
                break;
            case ("Rockefeller"): //physics, evolutionary biology
                description = "";
                break;
            case ("Sears"): //multicultural affairs, career center, disability resources,
                // educational services(mentoring/tutoring), study center, SOURCE
                // office, counseling services, department of astronomy
                description = "";
                break;
            case ("Smith"): //department of chemical and biomolecular engineering,
                // environmental studies program, earth environmental and planetary
                // sciences, natural sciences
                description = "";
                break;
            case ("Sophomore Dorms"):
                description = "";
                break;
            case ("Strosacker"): //largest lecture hall on campus AND it has a room
                // upstiars where you can sit an study
                description = "";
                break;
            case ("Thwing"): //postal substation, residence life, university housing,
                // jolly scholar
                description = "";
                break;
            case ("Tink"): //public sevice, commuter services, women's center, greek
                // life, lgbt, student activities and leadership,
                description = "";
                break;
            case ("Tomlinson"): //international affairs, international student
                // services, religious studies
                description = "";
                break;
            case ("Veale"):
                description = "This is CWRU's main GYM. This is the main location for " +
                        "most of our varsity and intramural sports, it also has a " +
                        "cardio workout room, a weight room, an open-access pool, " +
                        "basketball, racquetball, a rockwall, and an indoor track. " +
                        "Veale is also connected to our maker-space, and club meeting " +
                        "location, ThinkBox.";
                break;
            case ("White"): //materials science and engineering
                description = "";
                break;
            case ("Wickenden"): //biomedical engineering
                description = "";
                break;
            case ("Yost"): //financial aid, student employment, student financial
                // services, mathematics and statistics department
                description = "";
                break;
            default:
                description = "";
                break;
        }
    }
}
