/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.state.wizard.model;

import io.github.astrapi69.design.pattern.state.wizard.BaseWizardState;

/**
 * The enum {@link BaseWizardStateModel} represents three wizard states and the cancel with the
 * finish states. The state is only changing if the wizard model is valid.
 */
public enum BaseWizardStateModel
	implements BaseWizardState<BaseWizardStateMachineModel<WizardModel>>
{

	/** The first {@link BaseWizardStateModel} object. */
	FIRST {

		@Override
		public void cancel(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidCancel())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.CANCELED);
			}
		}

		@Override
		public void finish(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidFinish())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FINISHED);
			}
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidNext())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.SECOND);
				stateMachine.getModelObject().reset();
			}
		}

		@Override
		public void goPrevious(final BaseWizardStateMachineModel<WizardModel> input)
		{
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

	/** The second {@link BaseWizardStateModel} object. */
	SECOND {

		@Override
		public void cancel(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidCancel())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.CANCELED);
			}
		}

		@Override
		public void finish(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidFinish())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FINISHED);
			}
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidNext())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.THIRD);
				stateMachine.getModelObject().reset();
			}
		}

		@Override
		public void goPrevious(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidPrevious())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FIRST);
				stateMachine.getModelObject().reset();
			}
		}

	},

	/** The third {@link BaseWizardStateModel} object. */
	THIRD {

		@Override
		public void cancel(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidCancel())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.CANCELED);
			}
		}

		@Override
		public void finish(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidFinish())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FINISHED);
			}
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
		}

		@Override
		public void goPrevious(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidPrevious())
			{
				stateMachine.setCurrentState(SECOND);
				stateMachine.getModelObject().reset();
			}
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

	},

	/** The cancel {@link BaseWizardStateModel} object. */
	CANCELED {


		@Override
		public void cancel(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidCancel())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.CANCELED);
			}
		}

		@Override
		public void finish(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidFinish())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FINISHED);
			}
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
		}

		@Override
		public void goPrevious(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
		}

	},

	/** The finish {@link BaseWizardStateModel} object. */
	FINISHED {

		@Override
		public void cancel(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidCancel())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.CANCELED);
			}
		}

		@Override
		public void finish(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
			if (stateMachine.getModelObject().isValidFinish())
			{
				stateMachine.setCurrentState(BaseWizardStateModel.FINISHED);
			}
		}

		@Override
		public String getName()
		{
			return name();
		}

		@Override
		public void goNext(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
		}

		@Override
		public void goPrevious(final BaseWizardStateMachineModel<WizardModel> stateMachine)
		{
		}

	}
}
