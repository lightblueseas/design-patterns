package io.github.astrapi69.design.pattern.state.component;

public interface BtnSaveComponentState
{
	void onInitialize();

	void onGenerate();

	void onClear();

	void onChangeFilename();

	void onChangeDirectory();

	void onChangeKeySize();
}
