#!/bin/sh

# MQTT topics to subscribe to
TOPICS=(
"@/BLEManager/Enable"
"@/BLEManager/Advertisement"
"@/BLEManager/QRCode"
"@/BLEManager/Installer/Status"
"@/BLEManager/Installer/Address"
"@/BLEManager/Installer/RSSI"
"@/BLEManager/Installation/Status"
"@/BLEManager/Installation/Address"
"@/BLEManager/AuthCode"
"@/BLEManager/RCP"
"@/Tstat/Data/SystemMode/CurrentMode"
"@/Tstat/Data/SpStatus"
"@/Tstat/Data/Fan/SwitchPosition"
"@/Rpbroker/Relays_"
"@/Tstat/Data/ISUs/Info/Values"
"@/Tstat/Data/SystemMode"
"@/Tstat/Data/Fan"
"@/Rpbroker"
"@/Tstat/Data/ISUs"
"@/Tstat/Data/ISUs/Info"
"@/Tstat/Reset"
"@/FWuManager/Ota/Download"
"@/FWuManager/Ota/Update"
"@/FWuManager/Ota"
"@/NetManager/Enable"
"@/NetManager/"
"@/NetManager/Configuration/SavedNetworks"
"@/Tstat/Data/Time/UtcTime"
"@/Tstat/Data/Time"
"@/Tstat/Data/IndoorTemp"
"@/Tstat/Data/ISUs/IsSessionOpen"
"@/Tstat/Data/ISUs/Item"
"@/Tstat/Data/Alerts/Active"
"@/Tstat/Data/Rooms/ThermostatRoom"
"@/Tstat/Data/Rooms"
"@/NetManager/NetworkConfigurator/Creds"
"@/NetManager/NetworkConfigurator"
"@/NetManager/NetworkConfigurator/ConfigStatus"
"@/NetManager/ConnectivityCheck"
"@/NetManager/NetworkConfigurator/NetworkInfo"
"@/NetManager/Configuration"
"@/NetManager/NetworkInfo"
"@/Tstat/Data/IAQRating"
"@/Tstat/Data/ECo2"
"@/Tstat/Data/InternalHum"
"@/Tstat/Data/TVoc"
"@/Tstat/Data/Humidification/IndoorHumidity"
"@/Tstat/Data/Humidification/Config"
"@/Tstat/Data/Humidification/Config/Setpoint"
"@/Tstat/Data/Humidification/WindowProtectionEnabled"
"@/NetManager/#"
"@/Tstat/Data/Alerts"
"@/Tstat/Data/Dehumidification"
"@/Tstat/Data/Dehumidification/Setpoint"
"@/Tstat/Devices/Enrollment/Enabled"
"@/Tstat/Devices/Enrollment"
"@/Tstat/Devices/Enrollment/ConnectStatus"
"@/Tstat/Data/Schedule"
"@/Tstat/Devices/Delete"
"@/Tstat/Devices/Delete/Status"
"@/Tstat/Devices/Enrolled/Info/LastDevice"
"@/Tstat/Devices/Enrolled/Info"
"@/Tstat/DeviceInformation/ModelNumber"
"@/Tstat/DeviceInformation"
"@/Tstat/Data/Schedule/Enabled"
"@/Tstat/Data/Schedule/Reset"
"@/Tstat/Data/Ventilation"
"@/Tstat/Data/Ventilation/Capability"
"@/Tstat/Data/Ventilation/Capability/IsVentInSystem"
"@/Tstat/Data/Ventilation/Capability/HighOutdoorTempLockout"
"@/Tstat/Data/Ventilation/Capability/LowOutdoorTempLockout"
"@/Tstat/Data/Ventilation/Capability/HighOutdoorDewpointLockout"
"@/Tstat/Data/Ventilation/Status"
"@/Tstat/Data/Ventilation/Switch"
"@/Tstat/Data/Ventilation/TimedMinutes"
"@/Tstat/Data/Ventilation/Options"
"@/Tstat/Data/Ventilation/Options/IsDisabledDuringSleep"
"@/Tstat/Data/Ventilation/Options/HighOutdoorTempLockout"
"@/Tstat/Data/Ventilation/Options/LowOutdoorTempLockout"
"@/Tstat/Data/Ventilation/Options/HighOutdoorDewpointLockout"
"@/Tstat/Devices/Enrolled/Info/NumDevices"
"@/BLEManager/Enable/Connectable"
)

# Function to handle and format incoming messages
handle_message() {
    local topic="$1"
    local message="$2"
    local timestamp
    timestamp=$(date "+%Y-%m-%d %H:%M:%S") # Add timestamp in "YYYY-MM-DD HH:MM:SS" format

    echo "[$timestamp] Received Message | Topic: $topic | Payload: $message"
}

# Subscribe to the topics and process incoming messages
for topic in "${TOPICS[@]}"; do
    mosquitto_sub -t "$topic" | while IFS= read -r message; do
        clean_message=$(echo "$message" | tr -d '\r')  # Remove unwanted characters
        handle_message "$topic" "$clean_message"
    done &
done

# Keep the script running
wait
