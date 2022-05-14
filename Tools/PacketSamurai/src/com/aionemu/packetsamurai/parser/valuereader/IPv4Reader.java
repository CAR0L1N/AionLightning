/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */


/**
 * 
 */
package com.aionemu.packetsamurai.parser.valuereader;

import javax.swing.JComponent;
import javax.swing.JLabel;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.aionemu.packetsamurai.PacketSamurai;
import com.aionemu.packetsamurai.parser.datatree.ValuePart;

/**
 * @author Ulysses R. Ribeiro, modified Rolandas
 *
 */
public class IPv4Reader implements Reader
{

    public boolean loadReaderFromXML(Node n)
    {
        return true;
    }

    public String read(ValuePart part)
    {
        if (part.getBytesSize() == 4)
        {
            byte[] ip = part.getBytes();
            return (ip[0]&0xFF)+"."+(ip[1]&0xFF)+"."+(ip[2]&0xFF)+"."+(ip[3]&0xFF);
        }
        PacketSamurai.getUserInterface().log("ERROR: IPv4 Reader requires a part with exactly 4 bytes. Faulty part : "+part.getModelPart().getName());
        return "";
    }

    public JComponent readToComponent(ValuePart part)
    {
        return new JLabel(this.read(part));
    }

    public boolean saveReaderToXML(Element element, Document doc)
    {
        return true;
    }

}
