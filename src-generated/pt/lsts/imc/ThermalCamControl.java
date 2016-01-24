/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2015, Laboratório de Sistemas e Tecnologia Subaquática
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the names of IMC, LSTS, IMCJava nor the names of its 
 *       contributors may be used to endorse or promote products derived from 
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL LABORATORIO DE SISTEMAS E TECNOLOGIA SUBAQUATICA
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package pt.lsts.imc;

/**
 *  IMC Message Thermal Camera Control (1991)<br/>
 *  Message containing the protocol for thermal camera control.<br/>
 */

public class ThermalCamControl extends IMCMessage {

	public static final int ID_STATIC = 1991;

	public ThermalCamControl() {
		super(ID_STATIC);
	}

	public ThermalCamControl(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ThermalCamControl(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static ThermalCamControl create(Object... values) {
		ThermalCamControl m = new ThermalCamControl();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static ThermalCamControl clone(IMCMessage msg) throws Exception {

		ThermalCamControl m = new ThermalCamControl();
		if (msg == null)
			return m;
		if(msg.definitions != m.definitions){
			msg = msg.cloneMessage();
			IMCUtil.updateMessage(msg, m.definitions);
		}
		else if (msg.getMgid()!=m.getMgid())
			throw new Exception("Argument "+msg.getAbbrev()+" is incompatible with message "+m.getAbbrev());

		m.getHeader().values.putAll(msg.getHeader().values);
		m.values.putAll(msg.values);
		return m;
	}

	public ThermalCamControl(short processCode, short status, short function, int byteCount, byte[] args) {
		super(ID_STATIC);
		setProcessCode(processCode);
		setStatus(status);
		setFunction(function);
		setByteCount(byteCount);
		if (args != null)
			setArgs(args);
	}

	/**
	 *  @return Process code - uint8_t
	 */
	public short getProcessCode() {
		return (short) getInteger("processCode");
	}

	/**
	 *  @param processCode Process code
	 */
	public ThermalCamControl setProcessCode(short processCode) {
		values.put("processCode", processCode);
		return this;
	}

	/**
	 *  @return Status - uint8_t
	 */
	public short getStatus() {
		return (short) getInteger("status");
	}

	/**
	 *  @param status Status
	 */
	public ThermalCamControl setStatus(short status) {
		values.put("status", status);
		return this;
	}

	/**
	 *  @return Function - uint8_t
	 */
	public short getFunction() {
		return (short) getInteger("function");
	}

	/**
	 *  @param function Function
	 */
	public ThermalCamControl setFunction(short function) {
		values.put("function", function);
		return this;
	}

	/**
	 *  @return Byte count - uint16_t
	 */
	public int getByteCount() {
		return getInteger("byteCount");
	}

	/**
	 *  @param byteCount Byte count
	 */
	public ThermalCamControl setByteCount(int byteCount) {
		values.put("byteCount", byteCount);
		return this;
	}

	/**
	 *  @return Arguments - rawdata
	 */
	public byte[] getArgs() {
		return getRawData("args");
	}

	/**
	 *  @param args Arguments
	 */
	public ThermalCamControl setArgs(byte[] args) {
		values.put("args", args);
		return this;
	}

}
