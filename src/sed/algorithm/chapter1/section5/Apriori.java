package sed.algorithm.chapter1.section5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Apriori {

	private static final Logger log = LogManager.getLogger(Apriori.class);

	private int min_sport = 2;

	private List<String> items; // 这里面的内容一定要按照顺序存放
	private List<List<Integer>> bitVectorList = new ArrayList<List<Integer>>();
	private List<CFCon> candidateList = new ArrayList<CFCon>();
	private List<CFCon> freqenceList = new ArrayList<CFCon>();

	public static void main(String args[]) {
		Apriori apriori = new Apriori();

		apriori.generateData();
		apriori.apriMain();
		apriori.printFreqItems();

	}

	private void printFreqItems() {
		CFCon cfcL = freqenceList.get(freqenceList.size() - 1);
		for (CF cf : cfcL.cfList) {
			String kk = "";
			List<String> itemList = cf.itemList;
			for (int i = 0; i < itemList.size(); i++) {
				if (i == 0) {
					kk = itemList.get(i);
				} else {
					kk += "," + itemList.get(i);
				}
			}
			log.info("freqence: " + kk + " supCount:" + cf.supCount);
		}
	}

	private void apriMain() {
		// C1
		CFCon cfcC1 = find_frequent_1_itemsets();

		candidateList.add(cfcC1);
		CFCon cfcL1 = candidateToFreqent(cfcC1);
		freqenceList.add(cfcL1);

		CFCon cfcL = cfcL1;

		HashSet<String> set = new HashSet<String>();
		for (int k = 2; cfcL != null && cfcL.cfList != null
				&& cfcL.cfList.size() > 0; k++) {
			CFCon cfcCk = getCandateFroFreq(cfcL);
			// 为cfcC计数
			for (List<Integer> bitVector : bitVectorList) {
				set.clear();
				for (int i = 0; i < items.size(); i++) {
					int bit = bitVector.get(i);
					if (bit == 1) {
						set.add(items.get(i));
					}
				}
				List<CF> cfList = cfcCk.cfList;
				for (CF cf : cfList) {
					List<String> itemList = cf.itemList;
					boolean isAdd = true;
					for (String item : itemList) {
						if (!set.contains(item)) {
							isAdd = false;
							break;
						}
					}
					if (isAdd)
						cf.supCount++;
				}
			}

			cfcL = candidateToFreqent(cfcCk);
			if (cfcCk.cfList != null && cfcCk.cfList.size() > 0)
				candidateList.add(cfcCk);
			if (cfcL.cfList != null && cfcL.cfList.size() > 0)
				freqenceList.add(cfcL);
		}
	}

	/**
	 * 从L(k-1) 生成 C(k);
	 * 
	 * @param cfc
	 * @return
	 */
	private CFCon getCandateFroFreq(CFCon cfcL) {
		CFCon cfcC = null;

		if (cfcL != null) {
			cfcC = new CFCon(1, cfcL.iteratNum + 1);
			List<CF> cfList = cfcL.cfList;
			for (int outIndex = 0; outIndex < cfList.size(); outIndex++) {
				CF cfOut = cfList.get(outIndex);
				List<String> itemOutList = cfOut.itemList;
				for (int inIndex = outIndex + 1; inIndex < cfList.size(); inIndex++) {
					if (outIndex == inIndex)
						continue;

					CF cfIn = cfList.get(inIndex);
					List<String> itemInList = cfIn.itemList;

					List<String> itemList = new ArrayList<String>();

					boolean same = true;
					for (int index = 0; index < itemOutList.size() - 1; index++) {
						String out = itemOutList.get(index);
						String in = itemInList.get(index);
						if (out == null || in == null || !out.equals(in)) {
							same = false;
							break;
						}
						itemList.add(out);
					}
					if (same) {
						String out = itemOutList.get(itemOutList.size() - 1);
						String in = itemInList.get(itemInList.size() - 1);
						if (out != null && in != null && !out.equals(in)) {
							if (out.compareTo(in) >= 0) {
								itemList.add(in);
								itemList.add(out);
							} else {
								itemList.add(out);
								itemList.add(in);
							}
							CF cf = new CF(itemList, 0);
							if (!has_infreqent_subset(itemList, cfcL)) {
								cfcC.cfList.add(cf);
							}
						}
					}
				}
			}
		}

		return cfcC;
	}

	/**
	 * 在L(k-1)查找是否存在,cList(k-1)子集
	 * 
	 * @param cList
	 * @param cfc
	 *            L(k-1)
	 * @return
	 */
	private boolean has_infreqent_subset(List<String> cList, CFCon cfc) {
		HashSet<String> set = new HashSet<String>();

		List<CF> cfList = cfc.cfList;
		for (int index = 0; index < cfList.size(); index++) {
			CF cf = cfList.get(index);
			List<String> itemList = cf.itemList;
			String key = "";
			boolean first = true;
			for (String item : itemList) {
				if (first) {
					first = false;
					key = item;
				} else {
					key += "," + item;
				}
			}
			set.add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < cList.size(); index++) {

			sb.delete(0, sb.length());
			boolean first = true;
			for (int index2 = 0; index2 < cList.size(); index2++) {
				if (index2 == index)
					continue;
				else {
					if (first) {
						sb.append(cList.get(index2));
						first = false;
					} else {
						sb.append(",");
						sb.append(cList.get(index2));
					}
				}
			}
			boolean setCon = set.contains(sb.toString());
			if (!setCon)
				return true;
		}

		return false;
	}

	private class CFCon {

		List<CF> cfList;
		int cOrf; // 1.候选集，2,频繁集
		int iteratNum; // 迭代次数

		public CFCon(int cOrf, int iteratNum) {
			cfList = new ArrayList<CF>();
			this.cOrf = cOrf;
			this.iteratNum = iteratNum;
		}

		public CFCon(int n, int cOrf, int iteratNum) {
			this.cOrf = cOrf;
			this.iteratNum = iteratNum;
			cfList = new ArrayList<CF>();
			for (int index = 0; index < n; index++) {
				List<String> itemList = new ArrayList<String>();
				itemList.add(items.get(index));

				CF cf = new CF(itemList, 0);

				cfList.add(cf);
			}
		}
	}

	private class CF {
		List<String> itemList;
		int supCount;

		public CF(List<String> itemList, int supCount) {
			this.itemList = itemList;
			this.supCount = supCount;
		}
	}

	private CFCon find_frequent_1_itemsets() {

		CFCon cfc = null;
		if (bitVectorList != null && items != null) {
			cfc = new CFCon(items.size(), 1, 1);
			for (List<Integer> bitVector : bitVectorList) {
				if (bitVector != null) {
					for (int index = 0; index < bitVector.size(); index++) {
						int bit = bitVector.get(index);
						CF cf = cfc.cfList.get(index);
						if (bit == 1)
							cf.supCount++;
					}
				}
			}
		}
		return cfc;
	}

	/**
	 * 通过min_suport过滤掉最小的
	 * 
	 * @param cfcC
	 * @return
	 */
	private CFCon candidateToFreqent(CFCon cfcC) {
		List<CF> cfList = cfcC.cfList;

		CFCon cfcL = new CFCon(2, cfcC.iteratNum);
		if (cfList != null) {
			for (int index = cfList.size() - 1; index >= 0; index--) {
				CF cf = cfList.get(index);
				int supCount = cf.supCount;
				if (supCount >= min_sport) {
					cfcL.cfList.add(cf);
				}
			}
		}
		return cfcL;
	}

	private void generateData() {
		items = new ArrayList<String>();
		for (int index = 1; index <= 5; index++)
			items.add("I" + index);

//		bitVectorList.add(getStrList("1,1,0,0,1"));
//		bitVectorList.add(getStrList("0,1,0,1,0"));
//		bitVectorList.add(getStrList("0,1,1,0,0"));
//		bitVectorList.add(getStrList("1,1,0,1,0"));
//		bitVectorList.add(getStrList("1,0,1,0,0"));
//		bitVectorList.add(getStrList("0,1,1,0,0"));
//		bitVectorList.add(getStrList("1,0,1,0,0"));
//		bitVectorList.add(getStrList("1,1,1,0,1"));
//		bitVectorList.add(getStrList("1,1,1,0,0"));
		
		bitVectorList.add(getStrList("1,0,1,1,0"));
		bitVectorList.add(getStrList("0,1,1,0,1"));
		bitVectorList.add(getStrList("1,1,1,0,1"));
		bitVectorList.add(getStrList("0,1,0,0,1"));
		

	}

	private List<Integer> getStrList(String bitVector) {
		List<Integer> list = new ArrayList<Integer>();
		if (bitVector != null) {
			String[] bitArr = bitVector.split(",");
			for (String bit : bitArr) {
				list.add(Integer.parseInt(bit));
			}
		}
		return list;
	}
}
