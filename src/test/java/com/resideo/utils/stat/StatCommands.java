package com.resideo.utils.stat;

import java.util.concurrent.TimeUnit;

import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.utils.stat.cattgrpccommands.GrpcServiceGrpc;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StatCommands {
	private static StatCommands instance = null;

	public static boolean isInitialized = false;
	public static boolean isStatConnected = false;
	public static boolean forceRestartStat = false;
	public GrpcServiceGrpc.GrpcServiceBlockingStub cattCommandsStub;
	private ManagedChannel channel;
	public GrpcServiceGrpc.GrpcServiceBlockingStub MultiStatcattCommandsStub;
	private ManagedChannel MultiStatGrpcChannel;

	private StatCommands() {
		try {
			this.channel = ManagedChannelBuilder
					.forAddress(SuiteConstants
							.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "GRPC_SERVER_IP_ADDRESS").trim(),
							Integer.parseInt(SuiteConstants
									.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "GRPC_SERVER_PORT").trim()))
					.usePlaintext().build();

			cattCommandsStub = GrpcServiceGrpc.newBlockingStub(channel);

			cattCommandsStub.connectStat(String_Msg
					.newBuilder().setStrVal(SuiteConstants
							.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim())
					.build());

		} catch (Exception e) {
			System.out.println("Failed to Configure GRPC Server");
			System.out.println("Framework Configuration For GRPC : Exception Raied : " + e.getMessage());
		}
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public static StatCommands getInstance() {
		if (instance == null) {
			instance = new StatCommands();
			isInitialized = true;
		}

		return instance;
	}
	
	public static void setInstance(StatCommands instances) {
		instance = instances;
		isInitialized = false;
	}

	public void InitForMultiStatConnection(String serverIpAddress, String serverPort, String statPort) {
		this.MultiStatGrpcChannel = ManagedChannelBuilder.forAddress(serverIpAddress, Integer.parseInt(serverPort))
				.usePlaintext().build();
		MultiStatcattCommandsStub = GrpcServiceGrpc.newBlockingStub(MultiStatGrpcChannel);

		com.resideo.utils.stat.cattgrpccommands.String_Msg request = com.resideo.utils.stat.cattgrpccommands.String_Msg
				.newBuilder().setStrVal(statPort).build();
		MultiStatcattCommandsStub.connectStat(request);

	}
}
