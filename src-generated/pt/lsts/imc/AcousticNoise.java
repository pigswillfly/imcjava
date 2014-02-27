/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2013, Laboratório de Sistemas e Tecnologia Subaquática
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
 *                                                                             $:
 */

// Source generated by IMCJava from IMC version 5.4.x
package pt.lsts.imc;

/**
 *  IMC Message Acoustic Noise (208)<br/>
 *  Report on the conditions of the underwater medium, for when<br/>
 *  acoustic diagnostics are enabled.<br/>
 */

public class AcousticNoise extends IMCMessage {

	public static final int ID_STATIC = 208;

	public enum SUMMARY {
		NORMAL(0),
		LOW(1),
		HIGH(2),
		NO_SIGNAL(3);

		protected long value;

		public long value() {
			return value;
		}

		SUMMARY(long value) {
			this.value = value;
		}
	}

	public AcousticNoise() {
		super(ID_STATIC);
	}

	public AcousticNoise(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AcousticNoise(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static AcousticNoise create(Object... values) {
		AcousticNoise m = new AcousticNoise();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static AcousticNoise clone(IMCMessage msg) throws Exception {

		AcousticNoise m = new AcousticNoise();
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

	public AcousticNoise(SUMMARY summary, short level) {
		super(ID_STATIC);
		setSummary(summary);
		setLevel(level);
	}

	/**
	 *  Noise level characterization.<br/>
	 *  @return Summary (enumerated) - uint8_t
	 */
	public SUMMARY getSummary() {
		try {
			SUMMARY o = SUMMARY.valueOf(getMessageType().getFieldPossibleValues("summary").get(getLong("summary")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  @return Noise Level (db) - uint8_t
	 */
	public short getLevel() {
		return (short) getInteger("level");
	}

	/**
	 *  @param summary Summary (enumerated)
	 */
	public AcousticNoise setSummary(SUMMARY summary) {
		values.put("summary", summary.value());
		return this;
	}

	/**
	 *  @param summary Summary (as a String)
	 */
	public AcousticNoise setSummary(String summary) {
		setValue("summary", summary);
		return this;
	}

	/**
	 *  @param summary Summary (integer value)
	 */
	public AcousticNoise setSummary(short summary) {
		setValue("summary", summary);
		return this;
	}

	/**
	 *  @param level Noise Level (db)
	 */
	public AcousticNoise setLevel(short level) {
		values.put("level", level);
		return this;
	}

}
