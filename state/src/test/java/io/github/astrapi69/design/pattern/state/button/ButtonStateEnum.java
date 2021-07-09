package io.github.astrapi69.design.pattern.state.button;

public enum ButtonStateEnum implements SigninButtonState<TestButtonStateMachine>
{
	ENABLED {
		@Override
		public void onApplicationFileAdded(TestButtonStateMachine context)
		{
			context.onApplicationFileAdded(context);
		}

		@Override
		public void onChangeWithMasterPassword(TestButtonStateMachine context)
		{
			context.onChangeWithMasterPassword(context);
		}
	},
	DISABLED {
		@Override
		public void onApplicationFileAdded(TestButtonStateMachine context)
		{
			context.onApplicationFileAdded(context);
		}

		@Override
		public void onChangeWithMasterPassword(TestButtonStateMachine context)
		{
			context.onChangeWithMasterPassword(context);
		}

	}
}
