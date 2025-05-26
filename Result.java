public class Result {
    int position;
    int iterations;
    int instructions;

    public Result(int position, int iterations, int instructions) {
        this.position = position;
        this.iterations = iterations;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Posição: " + position + ", Iterações: " + iterations + ", Instruções: " + instructions;
    }

}
