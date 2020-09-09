package tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * create by
 *
 * @author hujin 2020/9/9
 */
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        List<Unit> units = Utils.getUnits();
        List<Node> nodes = buildTreeAndGetRoots(units);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(nodes);
        System.out.println(s);
    }

    private static List<Node> buildTreeAndGetRoots(List<Unit> units) {
        Map<String, Node> lookup = new HashMap<>();
        units.forEach(unit -> lookup.put(unit.getId(), new Node(unit)));
        lookup.values().forEach(node -> {
            Node parent;
            if (lookup.containsKey(node.getUnit().getParentId())) {
                parent = lookup.get(node.getUnit().getParentId());
                node.setParent(parent);
                parent.getChildren().add(node);
            }
        });
        return lookup.values()
                .stream()
                .filter(node -> node.getParent() == null)
                .collect(toList());
    }
}
