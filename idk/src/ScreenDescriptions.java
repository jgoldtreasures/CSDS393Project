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
                description = "Contains the civil and environmental engineering offices, " +
                        "lecture halls, and sleeping/studying spaces";
                break;
            case ("Carlton"):
                description = "Carlton Commons has a few study spaces as well as the rough " +
                        "rider room restaurant";
                break;
            case ("Crawford"): //Access Services, SAGES office, a cafe, childhood,
                // social justice institute,cognitive science studies,
                description = "Contains Access Services, SAGES office, a cafe, childhood, " +
                        "social justice institute, cognitive science studies, and assorted classrooms";
                break;
            case ("Dennys"):
                description = "A restaurant that allows CWRU special swipes and case cash";
                break;
            case ("Eldred"): //department of theater
                description = "Houses the theater and theater department";
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
                description = "macromolecular science and engineering offices, as well as" +
                        "lecture halls and labs";
                break;
            case ("Leutner"):
                description = "One of the two main dining halls on campus, also contains " +
                        "a restaurant and study spaces in the basement";
                break;
            case ("Millis"): //Connected to Clapp where the department of Chemistry is
                description = "Contains Millis-Schmidt Auditorium, and is connected to " +
                        "Clapp hall, home of the department of chemistry";
                break;
            case ("Nord"): //computer lab, engineering leadership and professional
                // practice, general engineering, peer advisors
                description = "Nord hall has computer labs, engineering leadership and professional " +
                        "practice offices, general engineering office, peer advisor centers, " +
                        "many lecture halls, study spaces, and Einstein's Bagels restaurant";
                break;
            case ("Olin"):
                description = "Olin contains the EECS lab, lecture halls, and the EECS office";
                break;
            case ("PBL"):
                description = "All business related majors can be found within this " +
                        "building.";
                break;
            case ("Rockefeller"): //physics, evolutionary biology
                description = "Contains the physics and evolutionary biology departments" +
                        " as well as a few lecture halls and labs";
                break;
            case ("Sears"): //multicultural affairs, career center, disability resources,
                // educational services(mentoring/tutoring), study center, SOURCE
                // office, counseling services, department of astronomy
                description = "The Sears building contains the office of multicultural affairs, the career center, " +
                        " disability resources, educational services(mentoring/tutoring)," +
                        " study centers, the SOURCE office, counseling services, and the" +
                        " department of astronomy";
                break;
            case ("Smith"): //department of chemical and biomolecular engineering,
                // environmental studies program, earth environmental and planetary
                // sciences, natural sciences
                description = "Smith hall contains the department of chemical and " +
                        "biomolecular engineering, the environmental studies program," +
                        " and the environmental and planetary sciences, and natural " +
                        "sciences departments";
                break;
            case ("Sophomore Dorms"):
                description = "Includes buildings such as Staley, Alumni, Tippit, " +
                        "Glaser, Kusch, and Michelson dorms";
                break;
            case ("Strosacker"): //largest lecture hall on campus AND it has a room
                // upstiars where you can sit an study
                description = "Strosacker is the largest lecture hall on campus, and" +
                        "contains study spaces as well";
                break;
            case ("Thwing"): //postal substation, residence life, university housing,
                // jolly scholar
                description = "Thwing has classrooms as well as the postal substation," +
                        " residence life office, university housing, grabit restaurant," +
                        " study spaces, and the jolly scholar bar";
                break;
            case ("Tink"): //public sevice, commuter services, women's center, greek
                // life, lgbt, student activities and leadership,
                description = "The Tinkham Veale University Center has the public service, " +
                        " commuter services, women's center, greek " +
                        "life, lgbt, student activities and leadership offices, " +
                        "as well as multiple restaurants, study spaces, and event areas";
                break;
            case ("Tomlinson"): //international affairs, international student
                // services, religious studies
                description = "Tomlinson has the international affairs, international student" +
                        " services, and religious studies offices, as well as a food court " +
                        "in the basement";
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
                description = "White building is home to the materials science and engineering" +
                        "department, as well as a few lecture halls and classrooms";
                break;
            case ("Wickenden"): //biomedical engineering
                description = "Wickenden has the biomedical engineering offices, along" +
                        " with a few lecture halls";
                break;
            case ("Yost"): //financial aid, student employment, student financial
                // services, mathematics and statistics department
                description = "Yost houses the financial aid, student employment, " +
                        "student financial services, offices, as well as the mathematics " +
                        "and statistics department";
                break;
            default:
                description = "";
                break;
        }
    }
}
