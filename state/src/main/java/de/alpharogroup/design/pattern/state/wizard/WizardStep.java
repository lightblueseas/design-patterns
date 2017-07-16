package de.alpharogroup.design.pattern.state.wizard;

/**
 * The enum {@link WizardStep} represents three wizard steps.
 */
public enum WizardStep implements WizardState<WizardStateMachine>
{

	/** The first {@link WizardStep} object. */
	FIRST {

		@Override
		public void cancel(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void finish(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void goNext(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(WizardStep.SECOND);
		}

		@Override
		public void goPrevious(WizardStateMachine input)
		{
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public boolean hasPrevious()
		{
			return false;
		}

		@Override
		public boolean isFirst()
		{
			return true;
		}

	},

	/** The second {@link WizardStep} object. */
	SECOND {

		@Override
		public void cancel(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void finish(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void goNext(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(WizardStep.THIRD);
		}

		@Override
		public void goPrevious(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(WizardStep.FIRST);
		}

		@Override
		public String getName()
		{
			return name();
		}

	},

	/** The third {@link WizardStep} object. */
	THIRD {


		@Override
		public void cancel(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void finish(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(null);
		}

		@Override
		public void goNext(WizardStateMachine stateMachine)
		{
		}

		@Override
		public void goPrevious(WizardStateMachine stateMachine)
		{
			stateMachine.setCurrentState(SECOND);
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public boolean hasNext()
		{
			return false;
		}

		@Override
		public boolean isLast()
		{
			return true;
		}

	};
}
