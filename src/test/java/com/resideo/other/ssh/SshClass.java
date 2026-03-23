package com.honeywell.commons.ssh;

//import net.schmizz.sshj.SSHClient;
//import net.schmizz.sshj.sftp.SFTPClient;
//import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

/**
 * Utility class for copying files from a remote server over SSH (SFTP). Works
 * like the shell command: scp user@host:/path/to/remote/file /local/directory
 */
public class SshClass {

	
	public static void copyFile(String host, String username, String password, String remotePath, String localDir)
			throws IOException, InterruptedException {

		SSHClient ssh = new SSHClient();

// Accept all host keys (not for production)
		ssh.addHostKeyVerifier(new HostKeyVerifier() {
			@Override
			public boolean verify(String hostname, int port, PublicKey key) {
				return true;
			}

			@Override
			public List<String> findExistingAlgorithms(String s, int i) {
				return null;
			}
		});

		try {
			
			System.out.println("Connecting to " + host + "...");
			ssh.connect(host, 22);

// Authenticate
			ssh.authPassword(username, password);
			
// Ensure local directory exists
			File outDir = new File(localDir);
			if (!outDir.exists() && !outDir.mkdirs()) {
				throw new IOException("Failed to create local directory: " + localDir);
			}

			String filename = new File(remotePath).getName();
			File localFile = new File(outDir, filename);

// Wait up to 5 minutes (300 seconds)
			int maxWaitSeconds = 300;
			int intervalSeconds = 5;
			boolean fileFound = false;

			try (SFTPClient sftp = ssh.newSFTPClient()) {
				for (int elapsed = 0; elapsed < maxWaitSeconds; elapsed += intervalSeconds) {
					try {
						sftp.stat(remotePath);
						System.out.println("File found on remote system: " + remotePath);
						fileFound = true;
						break;
					} catch (IOException e) {
						System.out.println(
								"File not found yet (" + elapsed + "s), retrying in " + intervalSeconds + "s...");
						Thread.sleep(intervalSeconds * 1000L);
					}
				}

				if (!fileFound) {
					System.out.println("File not present after waiting 5 minutes: " + remotePath);
					return;
				}

// Copy the file once it exists
				System.out.println("Copying file to local: " + localFile.getAbsolutePath());
				sftp.get(remotePath, localFile.getAbsolutePath());
				System.out.println("File copied successfully.");

			}

		} finally {
			ssh.disconnect();
			ssh.close();
		}
	}

	// Example usage
	public static void main(String[] args) {
		try {
			try {
				copyFile("192.168.134.141", // Host
						"root", // Username
						"root", // Password
						"/honeywell/runtime/screenshot1.png", // Remote file
						"./src/test/resources/Images/ScreenShotFromDenali" // Local directory
				);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
