package info.developia.util.structure.tree

import spock.lang.Shared
import spock.lang.Specification

class BinaryTreeTest extends Specification {

    @Shared
    var tree

    def setupSpec() {
        tree = new BinaryTree<>(Integer::compare)
        tree.add(12)
        tree.add(0)
        tree.add(1)
        tree.add(2)
        tree.add(4)
    }

    def "Add"() {
        when:
        def result = tree.size()
        then:
        result == 5
    }

    def "Contains"() {
        when:
        def result = tree.contains(2)
        then:
        result == true
    }

    def "Find"() {
        when:
        def result = tree.find(1)
        then:
        result == 1
    }
}
