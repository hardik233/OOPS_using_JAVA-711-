// Design a single Java class named UnifiedAssessmentExecutor for your university evaluation platform (similar to your Kargil DCPD automation systems) such that it extends one abstract class and implements two interfaces which both declare the same default method name. The abstract class AbstractAssessmentFlow must define a final template method executeAssessment() that internally calls validate(), prepare(), evaluate(), and publishResult() in this exact order, where only evaluate() is abstract. Two interfaces, AutoAssessment and ManualAssessment, both provide a default implementation of evaluate(), but with different internal logic. Your task is to design UnifiedAssessmentExecutor so that it resolves the multiple-inheritance conflict correctly, dynamically selects at runtime whether the auto or manual evaluation path should be used (based on a configuration flag such as isProctored(), still reuses both interface default implementations through proper use of InterfaceName.super.method(), guarantees that validate() can never be skipped by any future subclass, and ensures that Java's rule "class methods have higher priority than interface default methods" does not silently override the intended behaviour. The design must also allow future evaluation interfaces to be added later without modifying AbstractAssessmentFlow, while keeping the execution sequence strictly controlled by the abstract class.

interface AutoAssessment {
    default void evaluate() {
        System.out.println("Automatic Evaluation");
    }
}

interface ManualAssessment {
    default void evaluate() {
        System.out.println("Manual Evaluation");
    }
}

abstract class AbstractAssessmentFlow {

    public final void executeAssessment() {
        validate();
        prepare();
        evaluate();
        publishResult();
    }

    protected final void validate() {
        System.out.println("Validating...");
    }

    protected void prepare() {
        System.out.println("Preparing...");
    }

    protected abstract void evaluate();

    protected void publishResult() {
        System.out.println("Publishing...");
    }
}

public class UnifiedAssessmentExecutor extends AbstractAssessmentFlow implements AutoAssessment, ManualAssessment {
    private final boolean isProctoredExam;
    public UnifiedAssessmentExecutor(boolean isProctoredExam) {
        this.isProctoredExam = isProctoredExam;
    }
    public void evaluate() {
        System.out.println("Evaluating...");
        if (isProctoredExam == true) {
            System.out.println("MANUAL");
            ManualAssessment.super.evaluate();
        } else {
            System.out.println("AUTO");
            AutoAssessment.super.evaluate();
        }
    }

    public static void main(String[] args) {
        UnifiedAssessmentExecutor automaticAssessment = new UnifiedAssessmentExecutor(false);
        UnifiedAssessmentExecutor manualAssessment = new UnifiedAssessmentExecutor(true);
        automaticAssessment.executeAssessment();
        manualAssessment.executeAssessment();
    }
}