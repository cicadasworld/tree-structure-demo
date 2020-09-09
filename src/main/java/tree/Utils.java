package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * create by
 *
 * @author hujin 2020/9/9
 */
public class Utils {

    public static List<Unit> getUnits() {
        List<Unit> allUnits = new ArrayList<>();

        // 顶级单位
        Unit topUnit = null;
        {
            String id = UUID.randomUUID().toString().replace("-", "");
            topUnit = new Unit();
            topUnit.setId(id);
            topUnit.setName("顶级单位");
            topUnit.setParentId(null);
        }
        allUnits.add(topUnit);

        // 一级单位
        List<Unit> l1Units = new ArrayList<>();
        createUnit(topUnit, l1Units, 10, "一级单位");
        allUnits.addAll(l1Units);

        // 二级单位
        List<Unit> l2Units = new ArrayList<>();
        for (Unit l1Unit : l1Units) {
            createUnit(l1Unit, l2Units, 3, "二级单位");
        }
        allUnits.addAll(l2Units);

        // 三级单位
        List<Unit> l3Units = new ArrayList<>();
        for (Unit l2Unit : l2Units) {
            createUnit(l2Unit, l3Units, 3, "三级单位");
        }
        allUnits.addAll(l3Units);

        // 四级单位
        List<Unit> l4Units = new ArrayList<>();
        for (Unit l3Unit : l3Units) {
            createUnit(l3Unit, l4Units, 3, "四级单位");
        }
        allUnits.addAll(l4Units);

        // 五级单位
        List<Unit> l5Units = new ArrayList<>();
        for (Unit l4Unit : l4Units) {
            createUnit(l4Unit, l5Units, 3, "五级单位");
        }
        allUnits.addAll(l5Units);

        // 六级单位
        List<Unit> l6Units = new ArrayList<>();
        for (Unit l5Unit : l5Units) {
            createUnit(l5Unit, l6Units, 2, "六级单位");
        }
        allUnits.addAll(l6Units);
        return allUnits;
    }

    private static void createUnit(Unit parentUnit, List<Unit> units, int size, String name) {
        for (int i = 0; i < size; i++) {
            String id = UUID.randomUUID().toString().replace("-", "");
            String parentId = parentUnit.getId();
            Unit unit = new Unit();
            unit.setId(id);
            unit.setName(name);
            unit.setParentId(parentId);
            units.add(unit);
        }
    }
}
