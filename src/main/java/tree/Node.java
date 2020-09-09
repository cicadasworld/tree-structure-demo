package tree;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * create by
 *
 * @author hujin 2020/9/9
 */
public class Node {

    private Unit unit;
    @JsonIgnore
    private Node parent;
    private List<Node> children = new ArrayList<>();

    public Node(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
