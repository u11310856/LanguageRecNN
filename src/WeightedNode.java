import java.util.Random;

/**
 * <h1>The Weighted Node</h1>
 * This node class has a similar structure to the node class but it includes weights and points to other pointers.
 * This works with relation to the nodes that point to it. The class takes in all these weights and nodes and gets a net sum of them.
 * The net sum is then passed to an activation function which determines the final input value of the node.
 *
 * @author Trevor Austin
 * @version 1.0
 * @since 26/05/2015
 */
public class WeightedNode extends AbstractNode {
    /**
     * This variable stores the weights for all nodes related to this node.
     */
    private double[] weights;
    /**
     * This variable stores pointers to all the nodes.
     */
    AbstractNode[] nodes;
    /**
     * This is function used to activate the node.
     */
    ActivationFunction activationFunction;

    //TODO Update comments

    /**
     * This default constructor returns an error as the constructor cannot implemented correctly at this time.
     */
    public WeightedNode() {
        System.out.println("Weights were not set");
    }

    /**
     * This is the overloaded constructor of the class and allows the user to set the nodes pointed to and the current activation function.
     *
     * @param nodes              These are the nodes currently pointed to by the user.
     * @param activationFunction This is activation function that will be used.
     */
    public WeightedNode(AbstractNode[] nodes, ActivationFunction activationFunction) {
        this.nodes = nodes;
        this.activationFunction = activationFunction;
        weights = new double[nodes.length];
        generateWeights();
    }

    /**
     * This function will randomly generate the weights for the nodes.
     * It will only generate weights when the weights member variable has been set.
     */
    private void generateWeights() {
        //TODO Throw an error
        if (weights.length == 0)
            return;
        double fanin = weights.length;
        for (int i = 0; i < weights.length; i++) {
            Random rand = new Random();
            weights[i] = -1 / (Math.sqrt(fanin)) + ((1 / (Math.sqrt(fanin))) + (1 / (Math.sqrt(fanin)))) * rand.nextDouble();
        }
    }

    /**
     * Generates the input of the class using the net sum and the activation function. The net sum is generated by getting the sum of
     * the products of all the inputs and weights. Then the activation function is applied to the net sum.
     */
    private void generateInput() {
        double net = 0;
        for (int i = 0; i < nodes.length; i++) {
            net += nodes[i].getInput() * weights[i];
        }
        input = activationFunction.activate(net);
    }

    /**
     * TODO Comment and update
     */
    @Override
    public void update() {

    }

    /**
     * TODO Comment
     *
     * @return
     */
    @Override
    public double getInput() {
        generateInput();
        return input;
    }
}
