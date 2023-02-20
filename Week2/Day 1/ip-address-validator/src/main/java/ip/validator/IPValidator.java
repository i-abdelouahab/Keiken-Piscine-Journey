package ip.validator;

import java.util.function.Predicate;

public class IPValidator {
    public boolean ValidateIpv4Address(String ipAddress) {

        // Split the IP address string into 4 byte blocks
        String[] byteBlocks = ipAddress.split("\\.");

        // Check that there are exactly 4 byte blocks
        if (byteBlocks.length != 4) {
            return false;
        }

        // Check each byte block is a valid integer between 0 and 255
        for (String byteBlock : byteBlocks) {
            try {
                int blockValue = Integer.parseInt(byteBlock);
                if (blockValue < 0 || blockValue > 255) {
                    return false;
                }
                // Check that the address doesn't end in 0 or 255
                if (blockValue == 0 || blockValue == 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

            return true;
        }
}