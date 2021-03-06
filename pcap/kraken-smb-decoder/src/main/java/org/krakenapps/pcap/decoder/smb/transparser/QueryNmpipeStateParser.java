package org.krakenapps.pcap.decoder.smb.transparser;

import org.krakenapps.pcap.decoder.smb.SmbSession;
import org.krakenapps.pcap.decoder.smb.TransData;
import org.krakenapps.pcap.decoder.smb.rr.NamedPipeStatus;
import org.krakenapps.pcap.decoder.smb.transreq.QueryNmpipeStateRequest;
import org.krakenapps.pcap.decoder.smb.transresp.QueryNmpipeStateResponse;
import org.krakenapps.pcap.util.Buffer;
import org.krakenapps.pcap.util.ByteOrderConverter;

public class QueryNmpipeStateParser implements TransParser{

	@Override
	public TransData parseRequest(Buffer setupBuffer , Buffer parameterBuffer , Buffer dataBuffer) {
		QueryNmpipeStateRequest transData = new QueryNmpipeStateRequest();
		transData.setSubcommand(ByteOrderConverter.swap(setupBuffer.getShort()));
		transData.setFid(ByteOrderConverter.swap(setupBuffer.getShort()));
		return transData;
	}

	@Override
	public TransData parseResponse(Buffer setupBuffer , Buffer parameterBuffer , Buffer dataBuffer , SmbSession session) {
		QueryNmpipeStateResponse transData = new QueryNmpipeStateResponse();
		transData.setStatus(NamedPipeStatus.parse(ByteOrderConverter.swap(setupBuffer.getShort())));
		return transData;
	}
	

}
