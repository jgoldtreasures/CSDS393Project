import java.util.Arrays;
import java.util.List;

public class BuildingImplementation{
    public Building bingham, carlton, crawford, dennys, eldred, elephant, freshmanDorms,
            glennan, khs, ksl, leutner, millis, nord, olin, pbl, rockefeller, sears,
            smith, sophomoreDorms, strosacker, thwing, tink, tomlinson, veale, white,
            wickenden, yost;

    public BuildingImplementation(){
        bingham = new Building(452,220, "Bingham");
        carlton = new Building(575,405, "Carlton");
        crawford = new Building(130,505, "Crawford");
        dennys = new Building(220,140, "Dennys");
        eldred = new Building(219,315, "Eldred");
        elephant = new Building(455,435, "Elephant");
        freshmanDorms = new Building(120,110, "Freshman Dorms");
        glennan = new Building(572,260, "Glennan");

        khs = new Building(319,210, "KHS");
        ksl = new Building(615,430, "KSL");
        leutner = new Building(80,130, "Leutner");
        millis = new Building(272,230, "Millis");
        nord = new Building(422,347, "Nord");
        olin = new Building(502,313, "Olin");
        pbl = new Building(395,290, "PBL");
        rockefeller = new Building(287,320, "Rockefeller");

        sears = new Building(442,320, "Sears");
        smith = new Building(367,230, "Smith");
        sophomoreDorms = new Building(500,250, "Sophomore Dorms");
        strosacker = new Building(327,280, "Strosacker");
        thwing = new Building(605,315, "Thwing");
        tink = new Building(540,355, "Tink");
        tomlinson = new Building(242,485, "Tomlinson");

        veale = new Building(615,100, "Veale");
        white = new Building(517,287, "White");
        wickenden = new Building(342,385, "Wickenden");
        yost = new Building(287,440, "Yost");
    }
}
