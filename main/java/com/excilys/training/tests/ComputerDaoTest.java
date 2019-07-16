package main.java.com.excilys.training.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.java.com.excilys.training.model.Computer;
import main.java.com.excilys.training.persistence.CompanyDao;
import main.java.com.excilys.training.persistence.ComputerDao;

public class ComputerDaoTest extends TestCase {
	String url = "jdbc:mysql://localhost:3306/computer-database-db";
	String user = "admincdb";
	String passwd = "qwerty1234";
	String driver = "com.mysql.cj.jdbc.Driver";
	Connection conn;
	private ComputerDao c;
	@Before
	protected void setUp() throws Exception {
		try {
		      Class.forName(driver);
		      conn = DriverManager.getConnection(url, user, passwd);
		      
		      c = new ComputerDao(conn);
		}catch (Exception e) {
		      e.printStackTrace();
		    } 
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testDisplayAll() {
		StringBuffer th = new StringBuffer("1 MacBook Pro 15.4 inch null null 1 \n" + 
				"2 CM-2a null null 2 \n" + 
				"3 CM-200 null null 2 \n" + 
				"4 CM-5e null null 2 \n" + 
				"5 CM-5 1991-01-01 02:00:00 null 2 \n" + 
				"6 MacBook Pro 2006-01-10 02:00:00 null 1 \n" + 
				"7 Apple IIe null null null \n" + 
				"8 Apple IIc null null null \n" + 
				"9 Apple IIGS null null null \n" + 
				"10 Apple IIc Plus null null null \n" + 
				"11 Apple II Plus null null null \n" + 
				"12 Apple III 1980-05-01 01:00:00 1984-04-01 01:00:00 1 \n" + 
				"13 Apple Lisa null null 1 \n" + 
				"14 CM-2 null null 2 \n" + 
				"15 Connection Machine 1987-01-01 02:00:00 null 2 \n" + 
				"16 Apple II 1977-04-01 02:00:00 1993-10-01 02:00:00 1 \n" + 
				"17 Apple III Plus 1983-12-01 02:00:00 1984-04-01 01:00:00 1 \n" + 
				"18 COSMAC ELF null null 3 \n" + 
				"19 COSMAC VIP 1977-01-01 02:00:00 null 3 \n" + 
				"20 ELF II 1977-01-01 02:00:00 null 4 \n" + 
				"21 Macintosh 1984-01-24 02:00:00 null 1 \n" + 
				"22 Macintosh II null null null \n" + 
				"23 Macintosh Plus 1986-01-16 02:00:00 1990-10-15 02:00:00 1 \n" + 
				"24 Macintosh IIfx null null null \n" + 
				"25 iMac 1998-01-01 02:00:00 null 1 \n" + 
				"26 Mac Mini 2005-01-22 02:00:00 null 1 \n" + 
				"27 Mac Pro 2006-08-07 01:00:00 null 1 \n" + 
				"28 Power Macintosh 1994-03-01 02:00:00 2006-08-01 01:00:00 1 \n" + 
				"29 PowerBook 1991-01-01 02:00:00 2006-01-01 02:00:00 1 \n" + 
				"30 Xserve null null null \n" + 
				"31 Powerbook 100 null null null \n" + 
				"32 Powerbook 140 null null null \n" + 
				"33 Powerbook 170 null null null \n" + 
				"34 PowerBook Duo null null null \n" + 
				"35 PowerBook 190 null null null \n" + 
				"36 Macintosh Quadra 1991-01-01 02:00:00 null 1 \n" + 
				"37 Macintosh Quadra 900 null null null \n" + 
				"38 Macintosh Quadra 700 null null null \n" + 
				"39 Macintosh LC 1990-01-01 02:00:00 null 1 \n" + 
				"40 Macintosh LC II 1990-01-01 02:00:00 null 1 \n" + 
				"41 Macintosh LC III 1993-01-01 02:00:00 null 1 \n" + 
				"42 Macintosh LC III+ null null null \n" + 
				"43 Macintosh Quadra 605 1993-10-21 02:00:00 null 1 \n" + 
				"44 Macintosh LC 500 series null null null \n" + 
				"45 TRS-80 Color Computer 1980-01-01 02:00:00 null 5 \n" + 
				"46 Acorn System 2 null null null \n" + 
				"47 Dragon 32/64 null null null \n" + 
				"48 MEK6800D2 null null null \n" + 
				"49 Newbear 77/68 null null null \n" + 
				"50 Commodore PET null null 6 \n" + 
				"51 Commodore 64 1982-08-01 01:00:00 1994-01-01 02:00:00 6 \n" + 
				"52 Commodore 64C null null null \n" + 
				"53 Commodore SX-64 null null 6 \n" + 
				"54 Commodore 128 null null 6 \n" + 
				"55 Apple I 1976-04-01 01:00:00 1977-10-01 02:00:00 1 \n" + 
				"56 KIM-1 1975-01-01 02:00:00 null 7 \n" + 
				"57 Altair 8800 1974-12-19 02:00:00 null 8 \n" + 
				"58 IMSAI 8080 1975-08-01 02:00:00 null 9 \n" + 
				"59 IMSAI Series Two null null null \n" + 
				"60 VAX 1977-10-25 02:00:00 null 10 \n" + 
				"61 VAX 11/780 1977-10-25 02:00:00 null 10 \n" + 
				"62 VAX 11/750 1980-10-01 02:00:00 null 10 \n" + 
				"67 IBM PC 1981-08-12 01:00:00 null 13 \n" + 
				"68 Macintosh Classic null null null \n" + 
				"69 Macintosh Classic II 1991-01-01 02:00:00 null 1 \n" + 
				"70 Amiga 1985-01-01 02:00:00 null 14 \n" + 
				"71 Amiga 1000 null null 6 \n" + 
				"72 Amiga 500 1987-01-01 02:00:00 null 6 \n" + 
				"73 Amiga 500+ null null null \n" + 
				"74 Amiga 2000 1986-01-01 02:00:00 1990-01-01 02:00:00 6 \n" + 
				"75 Amiga 3000 null null 6 \n" + 
				"76 Amiga 600 1992-03-01 02:00:00 null 6 \n" + 
				"77 Macintosh 128K 1984-01-01 02:00:00 null 1 \n" + 
				"78 Macintosh 512K 1984-09-10 01:00:00 1986-04-14 01:00:00 1 \n" + 
				"79 Macintosh SE 1987-03-02 02:00:00 1989-08-01 01:00:00 1 \n" + 
				"80 Macintosh SE/30 1989-01-19 02:00:00 1991-10-21 02:00:00 1 \n" + 
				"81 Canon Cat 1987-01-01 02:00:00 null 15 \n" + 
				"82 Nokia 770 null null 16 \n" + 
				"83 Nokia N800 2007-01-01 02:00:00 null 16 \n" + 
				"84 Mylo 2006-09-21 01:00:00 null 17 \n" + 
				"85 OQO 02 2007-01-01 02:00:00 null 18 \n" + 
				"86 OQO 01+ null null null \n" + 
				"87 Pinwheel calculator null null null \n" + 
				"88 iBook null null 1 \n" + 
				"89 MacBook 2006-05-16 01:00:00 null 1 \n" + 
				"90 NeXTstation 1990-01-01 02:00:00 1993-01-01 02:00:00 19 \n" + 
				"91 NeXTcube 1988-01-01 02:00:00 1993-01-01 02:00:00 19 \n" + 
				"92 NeXTstation Color Turbo null null null \n" + 
				"93 NeXTstation Color null null null \n" + 
				"94 NeXTstation Turbo null null null \n" + 
				"95 NeXTcube Turbo null null 19 \n" + 
				"96 NeXTcube 040 null null 19 \n" + 
				"97 NeXTcube 030 null null 19 \n" + 
				"98 Tinkertoy Tic-Tac-Toe Computer null null null \n" + 
				"99 Z3 null null null \n" + 
				"100 Z4 null null null \n" + 
				"101 Z1 null null null \n" + 
				"102 Z2 null null null \n" + 
				"103 Wang 2200 1973-05-01 02:00:00 null null \n" + 
				"104 Wang VS null null null \n" + 
				"105 Wang OIS null null null \n" + 
				"106 BBC Micro null null 22 \n" + 
				"108 Cray-1 null null null \n" + 
				"109 Cray-3 null null null \n" + 
				"110 Cray-2 null null null \n" + 
				"111 Cray-4 null null null \n" + 
				"112 Cray X1 null null null \n" + 
				"113 Cray XD1 null null null \n" + 
				"114 Cray T3D 1993-01-01 02:00:00 null null \n" + 
				"115 Cray T3E 1995-01-01 02:00:00 null null \n" + 
				"116 Cray C90 null null null \n" + 
				"117 Cray T90 null null null \n" + 
				"118 Cray SV1 null null null \n" + 
				"119 Cray J90 null null null \n" + 
				"120 Cray XT3 null null null \n" + 
				"121 Cray CS6400 null null null \n" + 
				"122 Atari ST 1985-01-01 02:00:00 1993-01-01 02:00:00 20 \n" + 
				"123 Amiga 2500 null null null \n" + 
				"124 Amiga 2500 null null 6 \n" + 
				"125 Amiga 4000 null null 6 \n" + 
				"126 Amiga 3000UX null null 6 \n" + 
				"127 Amiga 3000T null null 6 \n" + 
				"128 Amiga 4000T null null 6 \n" + 
				"129 Amiga 1200 1992-10-01 02:00:00 1996-01-01 02:00:00 6 \n" + 
				"130 Atari 1040 STf 1986-01-01 02:00:00 null null \n" + 
				"131 Atari 520 ST 1985-01-01 02:00:00 null null \n" + 
				"132 Atari 520 STfm 1986-01-01 02:00:00 null null \n" + 
				"133 Atari 1040 STe 1989-01-01 02:00:00 null null \n" + 
				"134 Atari MEGA STe 1991-01-01 02:00:00 null null \n" + 
				"135 Atari 520 ST+ 1985-01-01 02:00:00 null null \n" + 
				"136 Atari 520 STm 1985-01-01 02:00:00 null null \n" + 
				"137 Atari 130 ST 1985-01-01 02:00:00 null null \n" + 
				"138 Atari 260 ST 1985-01-01 02:00:00 null null \n" + 
				"139 Atari MEGA ST 1987-01-01 02:00:00 null null \n" + 
				"140 Atari 520 STf 1986-01-01 02:00:00 null null \n" + 
				"141 Atari 1040 STfm 1986-01-01 02:00:00 null null \n" + 
				"142 Atari 2080 ST 1986-01-01 02:00:00 null null \n" + 
				"143 Atari 260 ST+ 1985-01-01 02:00:00 null null \n" + 
				"144 Atari 4160 STe 1988-01-01 02:00:00 null null \n" + 
				"145 TRS-80 Color Computer 2 null null null \n" + 
				"146 TRS-80 Color Computer 3 null null null \n" + 
				"147 TRS-80 Model 1 1977-01-01 02:00:00 null 5 \n" + 
				"148 Timex Sinclair 2068 1983-11-01 02:00:00 1984-04-01 01:00:00 23 \n" + 
				"149 ZX Spectrum 1982-01-01 02:00:00 null 25 \n" + 
				"150 Xerox Star 1981-01-01 02:00:00 null 26 \n" + 
				"151 Xerox Alto null null null \n" + 
				"152 Acorn Archimedes null null 22 \n" + 
				"153 Nintendo Entertainment System null null 24 \n" + 
				"154 Super Nintendo Entertainment System 1991-08-01 01:00:00 1999-01-01 02:00:00 24 \n" + 
				"155 Super Famicom null null null \n" + 
				"156 Nintendo GameCube null null 24 \n" + 
				"157 Game Boy line null null null \n" + 
				"158 PlayStation 1994-12-03 02:00:00 null 17 \n" + 
				"159 PlayStation 2 2000-03-24 02:00:00 null 17 \n" + 
				"160 Game & Watch null null 24 \n" + 
				"161 EDSAC null null null \n" + 
				"162 IBM System/4 Pi null null null \n" + 
				"163 IBM AP-101 null null null \n" + 
				"164 IBM TC-1 null null null \n" + 
				"165 IBM AP-101B null null null \n" + 
				"166 IBM AP-101S null null 13 \n" + 
				"167 ProLiant null null 27 \n" + 
				"168 Http://nepomuk.semanticdesktop.org/xwiki/ null null null \n" + 
				"169 Sinclair QL 1984-01-01 02:00:00 1986-01-01 02:00:00 25 \n" + 
				"170 Sinclair ZX81 1981-01-01 02:00:00 null 25 \n" + 
				"171 Sinclair ZX80 null null 25 \n" + 
				"172 Atari 65XE null null 20 \n" + 
				"173 Deep Blue null null null \n" + 
				"174 Macintosh Quadra 650 null null null \n" + 
				"175 Macintosh Quadra 610 null null null \n" + 
				"176 Macintosh Quadra 800 null null null \n" + 
				"177 Macintosh Quadra 950 null null null \n" + 
				"178 PowerBook 160 null null null \n" + 
				"179 PowerBook 145B null null null \n" + 
				"180 PowerBook 170 null null null \n" + 
				"181 PowerBook 145 null null null \n" + 
				"182 PowerBook G3 null null null \n" + 
				"183 PowerBook 140 null null null \n" + 
				"184 Macintosh IIcx null null null \n" + 
				"185 Powerbook 180 null null null \n" + 
				"186 PowerBook G4 null null null \n" + 
				"187 Macintosh XL null null null \n" + 
				"188 PowerBook 100 null null null \n" + 
				"189 PowerBook 2400c null null null \n" + 
				"190 PowerBook 1400 null null null \n" + 
				"191 Macintosh Quadra 630 null null null \n" + 
				"192 Macintosh Quadra 660AV null null null \n" + 
				"193 Macintosh Quadra 840AV null null null \n" + 
				"194 PowerBook 5300 null null null \n" + 
				"195 PowerBook 3400c null null null \n" + 
				"196 Macintosh Color Classic null null null \n" + 
				"197 Macintosh 512Ke null null null \n" + 
				"198 Macintosh IIsi null null null \n" + 
				"199 Macintosh IIx null null null \n" + 
				"200 PowerBook 500 series null null null \n" + 
				"201 Power Macintosh G3 null null null \n" + 
				"202 Macintosh IIci null null null \n" + 
				"203 iMac G5 2004-08-31 01:00:00 null 1 \n" + 
				"204 Power Mac G4 null null null \n" + 
				"205 Power Macintosh 7100 null null null \n" + 
				"206 Power Macintosh 9600 null null null \n" + 
				"207 Power Macintosh 7200 null null null \n" + 
				"208 Power Macintosh 7300 null null null \n" + 
				"209 Power Macintosh 8600 null null null \n" + 
				"210 Power Macintosh 6200 null null null \n" + 
				"211 Power Macintosh 8100 null null null \n" + 
				"212 Compact Macintosh null null null \n" + 
				"213 Power Macintosh 4400 null null null \n" + 
				"214 Power Macintosh 9500 null null null \n" + 
				"215 Macintosh Portable null null null \n" + 
				"216 EMac null null null \n" + 
				"217 Power Macintosh 7600 null null null \n" + 
				"218 Power Mac G5 null null null \n" + 
				"219 Power Macintosh 7500 null null null \n" + 
				"220 Power Macintosh 6100 null null null \n" + 
				"221 Power Macintosh 8500 null null null \n" + 
				"222 Macintosh IIvi null null null \n" + 
				"223 Macintosh IIvx null null null \n" + 
				"224 IMac G3 null null null \n" + 
				"225 IMac G4 null null null \n" + 
				"226 Power Mac G4 Cube null null 1 \n" + 
				"227 Intel iMac null null null \n" + 
				"228 Deep Thought null null 13 \n" + 
				"229 Wii 2006-11-19 02:00:00 null 24 \n" + 
				"230 IBM System x null null null \n" + 
				"231 IBM System i 2006-01-01 02:00:00 null 13 \n" + 
				"232 IBM System z 2006-01-01 02:00:00 null 13 \n" + 
				"233 IBM System p 2000-01-01 02:00:00 null 13 \n" + 
				"234 LC 575 null null null \n" + 
				"235 Macintosh TV null null null \n" + 
				"236 Macintosh Performa null null null \n" + 
				"237 Macintosh II series null null null \n" + 
				"238 Power Macintosh 6400 null null null \n" + 
				"239 Power Macintosh 6500 null null null \n" + 
				"240 Apple PenLite null null null \n" + 
				"241 Wallstreet null null null \n" + 
				"242 Twentieth Anniversary Macintosh null null null \n" + 
				"243 Power Macintosh 5500 null null null \n" + 
				"244 iBook G3 null null 1 \n" + 
				"245 Power Macintosh 5200 LC null null null \n" + 
				"246 Power Macintosh 5400 null null null \n" + 
				"247 CM-1 null null null \n" + 
				"248 MSX 1983-01-01 02:00:00 1995-01-01 02:00:00 28 \n" + 
				"249 PlayStation 3 null null 17 \n" + 
				"250 MSX2 1986-01-01 02:00:00 null 29 \n" + 
				"251 MSX2+ 1988-01-01 02:00:00 null 30 \n" + 
				"252 MSX turbo R 1990-01-01 02:00:00 null null \n" + 
				"253 Panasonic FS A1GT null null null \n" + 
				"254 Panasonic FS A1ST null null null \n" + 
				"255 PDP-11 null null 10 \n" + 
				"256 PDP-1 null null 10 \n" + 
				"257 PDP-10 null null 10 \n" + 
				"258 PDP-8 null null 10 \n" + 
				"259 PDP-6 null null 10 \n" + 
				"260 DECSYSTEM-20 null null 10 \n" + 
				"261 PDP-7 null null 10 \n" + 
				"262 PDP-5 null null 10 \n" + 
				"263 PDP-12 null null 10 \n" + 
				"264 LINC null null 10 \n" + 
				"265 PDP-14 null null 10 \n" + 
				"266 PDP-15 null null 10 \n" + 
				"267 PDP-16 null null 10 \n" + 
				"268 Cray X2 2007-01-01 02:00:00 null 31 \n" + 
				"269 Cray X-MP 1982-01-01 02:00:00 null 31 \n" + 
				"270 Evans & Sutherland ES-1 null null 32 \n" + 
				"271 Commodore VIC-20 1980-01-01 02:00:00 null 6 \n" + 
				"272 PowerBook 150 null null null \n" + 
				"273 MacBook Air 2008-01-15 02:00:00 null 1 \n" + 
				"275 Digi-Comp null null null \n" + 
				"276 Digi-Comp II null null 33 \n" + 
				"279 Nintendo 64 null null 24 \n" + 
				"280 Game Boy Advance null null 24 \n" + 
				"281 Game Boy null null 24 \n" + 
				"282 Nintendo DS Lite null null 24 \n" + 
				"283 Nintendo DS 2004-01-01 02:00:00 null 24 \n" + 
				"284 Game Boy Color null null 24 \n" + 
				"285 Game Boy Advance SP null null 24 \n" + 
				"286 Virtual Boy null null 24 \n" + 
				"287 Game Boy Micro null null 24 \n" + 
				"288 Roadrunner null null 13 \n" + 
				"289 HP 9000 null null null \n" + 
				"290 OMRON Luna-88K2 null null null \n" + 
				"291 OMRON Luna-88K null null 34 \n" + 
				"292 Motorola series 900 null null null \n" + 
				"293 Motorola M8120 null null null \n" + 
				"294 Triton Dolphin System 100 null null null \n" + 
				"295 BBN TC2000 1989-08-01 01:00:00 null 35 \n" + 
				"296 WRT54G null null null \n" + 
				"297 ThinkPad 1992-01-01 02:00:00 null 36 \n" + 
				"298 Apple Newton 1993-01-01 02:00:00 1998-01-01 02:00:00 1 \n" + 
				"301 ASUS Eee PC 901 null null 37 \n" + 
				"302 ASUS Eee PC 701 null null null \n" + 
				"304 System/38 1979-01-01 02:00:00 null 13 \n" + 
				"305 System/36 1983-01-01 02:00:00 2000-01-01 02:00:00 13 \n" + 
				"307 IBM RT null null 13 \n" + 
				"309 IBM 801 1980-01-01 02:00:00 null 13 \n" + 
				"311 ASCI White 2001-01-01 02:00:00 2006-01-01 02:00:00 13 \n" + 
				"312 Blue Gene null null 13 \n" + 
				"313 ASCI Blue Pacific 1998-01-01 02:00:00 null 13 \n" + 
				"314 iPhone 2007-06-01 01:00:00 null 1 \n" + 
				"315 Nokia N810 2007-10-17 01:00:00 null 16 \n" + 
				"316 EDSAC 2 null null null \n" + 
				"317 Titan null null null \n" + 
				"318 Pilot ACE null null null \n" + 
				"319 HP Mini 1000 2008-10-29 02:00:00 null 27 \n" + 
				"320 HP 2133 Mini-Note PC 2008-04-15 01:00:00 null 27 \n" + 
				"321 Kogan Agora Pro 2008-12-04 02:00:00 null null \n" + 
				"322 D-Series Machines null null null \n" + 
				"323 ZX Spectrum 48K 1982-01-01 02:00:00 null 25 \n" + 
				"324 ZX Spectrum 16K 1982-01-01 02:00:00 null 25 \n" + 
				"325 ZX Spectrum 128 1985-09-01 01:00:00 null 25 \n" + 
				"326 ZX Spectrum +3 null null 38 \n" + 
				"327 ZX Spectrum +2 1986-01-01 02:00:00 null 38 \n" + 
				"328 ZX Spectrum +2A 1987-01-01 02:00:00 null 38 \n" + 
				"329 ZX Spectrum + 1984-06-01 01:00:00 null 25 \n" + 
				"330 Acer Extensa null null null \n" + 
				"331 Acer Extensa 5220 null null null \n" + 
				"332 Dell Latitude null null null \n" + 
				"333 Toshiba Satellite null null null \n" + 
				"334 Timex Sinclair 2048 null null 23 \n" + 
				"335 Sprinter null null null \n" + 
				"336 Timex Computer 2048 null null null \n" + 
				"337 Pentagon null null null \n" + 
				"338 Belle null null null \n" + 
				"339 Loki null null 25 \n" + 
				"340 Hobbit null null null \n" + 
				"341 NeXT Computer null null 19 \n" + 
				"342 TRS-80 null null null \n" + 
				"343 TRS-80 Model 2 1980-01-01 02:00:00 null 5 \n" + 
				"344 TRS-80 Model 3 null null 5 \n" + 
				"345 STacy 1989-01-01 02:00:00 null null \n" + 
				"346 ST BOOK 1990-01-01 02:00:00 null null \n" + 
				"347 Atari 520 STE 1989-01-01 02:00:00 null null \n" + 
				"348 Amiga 2000 Model A null null null \n" + 
				"349 Amiga 2000 Model B null null null \n" + 
				"350 Amiga 2000 Model C null null null \n" + 
				"351 IBM 3270 null null null \n" + 
				"352 CALDIC null null null \n" + 
				"353 Modbook null null null \n" + 
				"354 Compaq SystemPro null null null \n" + 
				"355 ARRA null null null \n" + 
				"356 IBM System Cluster 1350 null null null \n" + 
				"357 Finite element machine null null null \n" + 
				"358 ES7000 null null null \n" + 
				"359 HP MediaSmart Server null null null \n" + 
				"360 HP Superdome null null null \n" + 
				"361 IBM Power Systems 2008-01-01 02:00:00 null 13 \n" + 
				"362 Oslo Analyzer null null null \n" + 
				"363 Microsoft Softcard null null null \n" + 
				"364 WITCH null null null \n" + 
				"365 Analytical engine null null null \n" + 
				"366 EDVAC null null null \n" + 
				"367 BINAC null null null \n" + 
				"368 Earth Simulator null null null \n" + 
				"369 BARK null null null \n" + 
				"371 ILLIAC IV null null null \n" + 
				"372 ILLIAC II null null null \n" + 
				"373 ILLIAC III null null null \n" + 
				"374 Water integrator null null null \n" + 
				"375 CSIRAC null null null \n" + 
				"376 System X null null null \n" + 
				"377 Harvest null null null \n" + 
				"378 ChipTest null null null \n" + 
				"379 HiTech null null null \n" + 
				"380 Bomba null null null \n" + 
				"381 ACE null null null \n" + 
				"382 ASCI Red null null null \n" + 
				"383 ASCI Thors Hammer null null null \n" + 
				"384 ASCI Purple 2005-01-01 02:00:00 null 13 \n" + 
				"385 ASCI Blue Mountain null null null \n" + 
				"386 Columbia null null null \n" + 
				"387 HP Integrity null null null \n" + 
				"388 APEXC null null null \n" + 
				"389 Datasaab D2 null null null \n" + 
				"390 BRLESC null null null \n" + 
				"391 DYSEAC null null null \n" + 
				"393 Hydra null null null \n" + 
				"394 FUJIC null null null \n" + 
				"395 RAYDAC null null null \n" + 
				"396 Harvard Mark III null null null \n" + 
				"397 DATAR null null null \n" + 
				"398 ReserVec null null null \n" + 
				"399 DASK null null null \n" + 
				"400 UTEC null null null \n" + 
				"401 DRTE Computer null null null \n" + 
				"402 PowerEdge null null null \n" + 
				"403 Apple Network Server null null null \n" + 
				"404 Goodyear MPP null null null \n" + 
				"405 Macintosh 128K technical details null null null \n" + 
				"406 Power Macintosh G3 null null null \n" + 
				"407 CER-10 null null null \n" + 
				"408 CER-20 null null null \n" + 
				"409 IBM BladeCenter 2002-01-01 02:00:00 null 13 \n" + 
				"410 Wisconsin Integrally Synchronized Computer null null null \n" + 
				"411 Amstrad CPC null null 38 \n" + 
				"412 Amstrad CPC 6128 null null 38 \n" + 
				"413 Amstrad CPC 664 null null 38 \n" + 
				"414 Amstrad CPC 464 null null 38 \n" + 
				"415 Intergraph null null null \n" + 
				"416 Enterprise null null null \n" + 
				"417 MTX500 null null null \n" + 
				"418 Acorn Electron null null null \n" + 
				"419 Sony Vaio P 2009-02-01 02:00:00 null 17 \n" + 
				"420 VAIO null null 17 \n" + 
				"421 Sony Vaio P VGN-P588E/Q null null null \n" + 
				"422 Sony Vaio P VGN-P530H/G null null null \n" + 
				"423 Sony Vaio P VGN-P530H/W null null null \n" + 
				"424 Sony Vaio P VGN-P530H/Q null null null \n" + 
				"425 Sony Vaio P VGN-P530H/R null null null \n" + 
				"426 Sony Vaio P VGN-P588E/R null null null \n" + 
				"427 Sony Vaio P VGN-P598E/Q null null null \n" + 
				"428 Timex Sinclair 1000 1982-07-01 01:00:00 null 23 \n" + 
				"429 Komputer 2086 null null null \n" + 
				"430 Galaksija null null null \n" + 
				"431 Vector-06C null null null \n" + 
				"432 Elektronika BK null null null \n" + 
				"433 Sun386i null null 39 \n" + 
				"434 Xerox Daybreak 1985-01-01 02:00:00 1989-01-01 02:00:00 null \n" + 
				"435 Xerox NoteTaker null null 26 \n" + 
				"437 LGP-30 null null null \n" + 
				"438 LGP-21 null null null \n" + 
				"439 ASUS Eee PC 900 2008-05-01 01:00:00 null 37 \n" + 
				"440 Atari TT030 null null null \n" + 
				"441 Bi Am ZX-Spectrum 48/64 null null null \n" + 
				"442 Bi Am ZX-Spectrum 128 null null null \n" + 
				"443 PlayStation Portable null null null \n" + 
				"444 MSI Wind Netbook null null null \n" + 
				"445 Sharp Mebius NJ70A 2009-04-21 01:00:00 null null \n" + 
				"446 HTC Snap null null 41 \n" + 
				"447 Commodore Educator 64 null null 6 \n" + 
				"448 Amiga 1500 null null 6 \n" + 
				"449 Commodore 65 null null 6 \n" + 
				"450 Commodore 16 null null 6 \n" + 
				"451 Commodore CBM-II null null 6 \n" + 
				"452 Commodore Plus/4 null null 6 \n" + 
				"453 Commodore LCD null null 6 \n" + 
				"454 Commodore MAX Machine null null 6 \n" + 
				"455 Aster CT-80 null null null \n" + 
				"456 Test 2009-01-01 02:00:00 2009-01-01 02:00:00 null \n" + 
				"457 MSI GX723 null null null \n" + 
				"458 Eee PC 1000HV 2009-05-22 01:00:00 null null \n" + 
				"459 VTech Laser 200 1983-01-01 02:00:00 null null \n" + 
				"460 CrunchPad null null null \n" + 
				"461 Neo Geo 1990-01-01 02:00:00 null null \n" + 
				"462 Sega Mega Drive null null null \n" + 
				"463 Sega Master System null null null \n" + 
				"464 TurboGrafx-16 null null null \n" + 
				"465 Sun-3 null null 39 \n" + 
				"466 Pleiades null null null \n" + 
				"467 IBM Sequoia null null null \n" + 
				"468 Inves Spectrum 48k plus null null null \n" + 
				"469 iPhone 3G null null null \n" + 
				"470 iPhone 3GS null null null \n" + 
				"471 Beagle Board null null 40 \n" + 
				"472 HP nPar null null null \n" + 
				"473 MacBook Family null null null \n" + 
				"474 Reservisor null null null \n" + 
				"475 BladeSystem null null null \n" + 
				"476 lenovo thinkpad t60p null null null \n" + 
				"477 lenovo thinkpad x200 null null 36 \n" + 
				"478 lenovo thinkpad t60 null null null \n" + 
				"479 lenovo thinkpad w700 null null null \n" + 
				"480 lenovo thinkpad t41 null null null \n" + 
				"481 lenovo thinkpad z61p null null null \n" + 
				"482 lenovo thinkpad x61s null null null \n" + 
				"483 lenovo thinkpad t43 null null null \n" + 
				"484 lenovo thinkpad r400 null null null \n" + 
				"485 lenovo thinkpad x60s null null null \n" + 
				"486 lenovo thinkpad x301 null null null \n" + 
				"487 lenovo thinkpad t42 null null null \n" + 
				"488 lenovo thinkpad r61 null null null \n" + 
				"489 lenovo thinkpad w500 null null null \n" + 
				"490 lenovo thinkpad sl400 null null null \n" + 
				"491 lenovo thinkpad x40 null null null \n" + 
				"492 lenovo thinkpad x200 tablet null null 36 \n" + 
				"493 lenovo thinkpad t400s null null null \n" + 
				"494 Nokia N900 2009-10-01 01:00:00 null 16 \n" + 
				"495 Internet Tablet null null null \n" + 
				"496 Meiko Computing Surface 1986-01-01 02:00:00 1993-01-01 02:00:00 null \n" + 
				"497 CS-2 null null null \n" + 
				"499 IBM 5100 1975-01-01 02:00:00 null 13 \n" + 
				"503 System/34 1978-01-01 02:00:00 1983-01-01 02:00:00 13 \n" + 
				"504 System/32 1975-01-01 02:00:00 null 13 \n" + 
				"507 English Electric DEUCE null null null \n" + 
				"508 CER-203 null null null \n" + 
				"509 CER-22 null null null \n" + 
				"510 Kentucky Linux Athlon Testbed null null null \n" + 
				"511 QNAP TS-101 null null null \n" + 
				"512 iPad 2010-01-01 02:00:00 2011-03-02 02:00:00 1 \n" + 
				"513 iPhone 2G null null null \n" + 
				"514 Inslaw null null null \n" + 
				"515 WePad 2010-07-01 01:00:00 null null \n" + 
				"516 MacBook Parts null null 1 \n" + 
				"517 MacBook 13-inch Core 2 Duo 2.13GHz (MC240LL/A) DDR2 Model null null 1 \n" + 
				"518 MacBook 13-inch Core 2 Duo 2.13GHz (MC240T/A) DDR2 Model null null null \n" + 
				"519 MacBook 13-inch Core 2 Duo 2.13GHz (MC240X/A) DDR2 Model null null null \n" + 
				"520 MacBook 13-inch Core 2 Duo 2.26GHz (Unibody MC207LL/A) DDR3 Model null null null \n" + 
				"521 MC240LL/A null null null \n" + 
				"522 D.K.COMMUNICATION null null null \n" + 
				"523 iPhone 4 null null 1 \n" + 
				"524 Nintendo 3DS 2010-03-23 02:00:00 null 24 \n" + 
				"525 ASUS Eee PC 1005PE 2010-01-01 02:00:00 null 37 \n" + 
				"526 National Law Enforcement System null null null \n" + 
				"527 BlackBerry PlayBook null null 42 \n" + 
				"528 Barnes & Noble nook 2009-10-20 01:00:00 null null \n" + 
				"529 SAM Coupé null null null \n" + 
				"530 HTC Dream 2008-10-22 01:00:00 null 41 \n" + 
				"531 Samsung Galaxy Tab 2010-09-02 01:00:00 null 43 \n" + 
				"532 BlackBerry PlayBook 2010-09-27 01:00:00 null 42 \n" + 
				"533 Tianhe-I null null null \n" + 
				"534 Kno null null null \n" + 
				"535 ThinkPad 701 C null null null \n" + 
				"536 ThinkPad 340 CSE null null null \n" + 
				"537 ThinkPad 755 CX null null null \n" + 
				"538 ThinkPad 755 CE null null null \n" + 
				"539 ThinkPad 370 C null null null \n" + 
				"540 Coleco Adam 1983-01-01 02:00:00 null null \n" + 
				"541 Nebulae null null null \n" + 
				"542 Alex eReader null null null \n" + 
				"543 Acer Iconia null null null \n" + 
				"544 Archos 101 null null null \n" + 
				"545 Fujitsu Lifebook T900 null null null \n" + 
				"546 Motorola Xoom null null null \n" + 
				"547 ViewSonic G Tablet null null null \n" + 
				"548 DEC Professional 1982-01-01 02:00:00 null 10 \n" + 
				"549 DEC Multia 1994-11-07 02:00:00 null 10 \n" + 
				"550 DEC Firefly null null 10 \n" + 
				"551 DEC 3000 AXP null null 10 \n" + 
				"552 DEC 2000 AXP 1993-05-25 01:00:00 null 10 \n" + 
				"553 DEC 4000 AXP 1992-11-10 02:00:00 null 10 \n" + 
				"554 DEC 7000/10000 AXP 1992-11-10 02:00:00 null 10 \n" + 
				"555 DEC Professional 350 null null null \n" + 
				"556 DEC Rainbow 100 null null null \n" + 
				"557 DEC Professional 325 null null null \n" + 
				"558 DECmate II null null 10 \n" + 
				"559 DECmate null null 10 \n" + 
				"560 DECsystem null null 10 \n" + 
				"561 NetApp Filer null null null \n" + 
				"562 DEC GT40 null null 10 \n" + 
				"563 ecoATM null null null \n" + 
				"564 MindWave BrainCubed Education Bundle null null null \n" + 
				"565 PalmPilot null null null \n" + 
				"566 Upcoming iPhone 5 null null 1 \n" + 
				"567 Dell Inspiron 560 Desktop Computer  null null null \n" + 
				"568 IPad 2 null null 1 \n" + 
				"569 HP TouchPad 2011-02-09 02:00:00 null 27 \n" + 
				"570 HP Veer 2011-02-09 02:00:00 null 27 \n" + 
				"571 Lenovo Thinkpad Edge 11 null null 36 \n" + 
				"572 Dell Vostro null null null \n" + 
				"573 Gateway LT3103U 2008-01-01 02:00:00 null null \n" + 
				"574 iPhone 4S 2011-10-14 01:00:00 null 1 \n");
		StringBuffer pr = c.displayAll();
		assertTrue(th.toString().compareTo(pr.toString())==0);
	}

	@Test
	public void testComputerDao() {
		assertNotNull("L'instance n'est pas créée", c);
	}

	@Test
	public void testDisplayInt() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId);
		Computer computerPr = c.display(507);
		assertEquals(computerTh, computerPr);
	}

	@Test
	public void testCreateComputer() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(575,"CX", introduced,discontinued, companyId);
		c.create(computerTh);
		List<Computer> listc = c.computers();
		assertTrue(listc.contains(computerTh));
	}

	@Test
	public void testDeleteComputer() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(575,"CX", introduced,discontinued, companyId);
		c.delete(computerTh);
		List<Computer> listc = c.computers();
		assertFalse(listc.contains(computerTh));
	}

	@Test
	public void testUpdateComputerStringString() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId);
		c.update(computerTh, "507","English Electric DEUCE", null, null, null);
		List<Computer> listc = c.computers();
		assertTrue(listc.contains(computerTh));
	}

}
