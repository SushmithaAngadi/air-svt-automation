package com.resideo.keywords.stat.relays;

import java.util.ArrayList;
import java.util.Iterator;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatRelayUtils;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg.Relays;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.cucumber.java.en.Given;

public class VerifyPhysicalRelays extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyPhysicalRelays(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}
	@Given(value= "^user verifies \"(.*)\" relays turned \"(.*)\" with \"(.*)\" wait time$")
	@Override
	@KeywordStep(gherkins = "^user verifies \"(.*)\" relays turned \"(.*)\" with \"(.*)\" wait time$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful() && flag) {
			KeepAppActive appActive = new KeepAppActive(testCase);
			try {
				Keyword.ReportStep_Pass(testCase, "<b>Keyword steps:</b>");

				appActive.start();
				
				String[] strRelays = exampleData.get(0).split(":");
				ArrayList<Relays> expectedRelays1 = new ArrayList<>();
//                                                            ArrayList<PhysicalRelayMsg> TurnedOnRelays = new ArrayList<PhysicalRelayMsg>();
				for (String s : strRelays) {
					switch (Relays.valueOf(s)) {
					case E: {
						expectedRelays1.add(Relays.E);
						break;
					}
					case G: {
						expectedRelays1.add(Relays.G);
						break;
					}
					case U1: {
						expectedRelays1.add(Relays.U1);
						break;
					}
					case W2_AUX: {
						expectedRelays1.add(Relays.W2_AUX);
						break;
					}
					case W_OB: {
						expectedRelays1.add(Relays.W_OB);
						break;
					}
					case Y: {
						expectedRelays1.add(Relays.Y);
						break;
					}
					case Y2: {
						expectedRelays1.add(Relays.Y2);
						break;
					}
					default: {
						break;
					}
					}
				}

				Iterable<Relays> relayIterable = new Iterable<PhysicalRelayMsg.Relays>() {

					@Override
					public Iterator<Relays> iterator() {

						return expectedRelays1.iterator();
					}
				};

				if (!exampleData.get(2).toUpperCase().contains("0")
						&& !exampleData.get(2).toUpperCase().contains("NO")) 
				{
					flag = flag && StatRelayUtils.verifyRelays(testCase, expectedRelays1, exampleData.get(1), Integer.parseInt(exampleData.get(2).toUpperCase().split("_")[0]));
				}
				else 
				{
					if (exampleData.get(1).toUpperCase().contains("ON")) {
						if (StatCommands.getInstance().cattCommandsStub
								.verifyPhysicalRelays(PhysicalRelayMsg.newBuilder().addAllRelay(relayIterable).build())
								.getBoolVal()) {
							Keyword.ReportStep_Pass(testCase,
									"Relays " + exampleData.get(0).toUpperCase() + " are turned ON as expected");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Expected relays " + exampleData.get(0).toUpperCase() + " are NOT turned ON");
							// TODO - Get relays which are turned on
							PhysicalRelayMsg physicalRelays = StatCommands.getInstance().cattCommandsStub
									.getPhysicalRelays(String_Msg.newBuilder().build());
							System.out.println(physicalRelays);
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Relays " + physicalRelays.getRelayList().toString() + " are turned on instead");
							flag = false;
						}
					} else {
						// TODO - GRPC command Yet to implement
						/*
						 * Get relays compare with expected relays, if all expected relays are turned
						 * off, pass the keyword steps else fail
						 */
					}
					
				}
				
				appActive.requestStop();
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());

				if (appActive.isAlive())
					appActive.requestStop();
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}

}
