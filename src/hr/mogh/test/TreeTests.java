package hr.mogh.test;

import hr.mogh.trees.Node;
import hr.mogh.trees.TreeGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by vlado on 9.10.2015..
 */
public class TreeTests {



    @Test
    public void treeGenerationTest() {
        Node root = TreeGenerator.generateOffByOneLetterTree();
        Assert.assertNotNull(root.getChildren());
        Assert.assertTrue(root.getChildren().size() > 0);
    }

}
