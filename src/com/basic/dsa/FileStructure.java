package com.basic.dsa;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileStructure {

	public static void main(String[] args) {

		String path = "file-info.txt";
		File file = new File(path);
		String fileData = "";
		try (FileInputStream fin = new FileInputStream(file)) {
			byte bytes[] = new byte[fin.available()];
			fin.read(bytes, 0, fin.available());
			fileData = new String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Directory head = createDirHierarchy(fileData);

		//System.out.println(head);
		
		System.out.println();
		Set<String> dirs = getAllDir(head);
		System.out.println("List of Dirs: "+dirs);
		
		System.out.println();
		Set<String> files = getAllFiles(head);
		System.out.println("List of Files: "+files);
		
		System.out.println();
		Map<String, Long> map =getAllDirSizes(head, dirs);
		System.out.println("All Dirs Info: "+map);
		
		System.out.println();
		System.out.println("Size of pareek: "+ getDirSizes(getDirByName(head, "pareek")));
		
		//Directory node = getDirByName(head, "acip.doc");
		//if (node != null)
		//	System.out.println(node.getName() + ", " + node.getType() + ", " + node.getSize() + ", "
		//			+ node.getParent().getName());

	}

	public static Directory createDirHierarchy(String fileData) {

		Directory root = null;
		String rows[] = fileData.trim().split("\n");

		String rootColumns[] = rows[0].trim().split("\\s*,\\s*");
		if (rootColumns[3].equalsIgnoreCase("NONE"))
			root = new Directory(rootColumns[0], rootColumns[1], Long.parseLong(rootColumns[2]), null);
		else
			throw new RuntimeException("Invalid file data, all parent should be defined prior than child.");

		for (int i = 1; i < rows.length; i++) {
			String columns[] = rows[i].trim().split("\\s*,\\s*");
			Directory parent = getDirByName(root, columns[3]);
			if(parent==null) throw new RuntimeException("Invalid file data, all parent should be defined prior than child.");
			System.out.println(">>>: " +columns[0]+" ***added to dir*** "+parent.getName());
			Directory newDir = new Directory(columns[0], columns[1], Long.parseLong(columns[2]), parent);
			parent.getChilds().add(newDir);
		}
		
		return root;
	}
	
	
	/**
	 *  Get directory by name in tree hierarchy.
	 * @param parent
	 * @param name
	 * @return
	 */
	public static Directory getDirByName(Directory parent, String name) {
		Directory node = null;
	    if (parent == null) {
	    	return parent;
	    } else if (parent.getName().equals(name)) {
	    	return parent;
	    } else {
	        for (Directory child : parent.getChilds()) {
	        	node = getDirByName(child, name);
	            if (node != null) break;
	        }
	    }
	    return node;
	}
	
	/** Get unique list of all directories in tree hierarchy.
	 * @param parent
	 * @return return unique list
	 */
	public static Set<String> getAllDir(Directory parent){
		
		return getAllDir(parent, null);
	}
	/**Get unique list of all directories in tree hierarchy. It appends in input list.
	 * @param parent
	 * @param dirList
	 * @return return unique list, It appends in input list.
	 */
	public static Set<String> getAllDir(Directory parent, Set<String> dirList) {

		if(dirList== null) dirList = new LinkedHashSet<>();
		
		if (parent == null) {
	    	return dirList;
	    }
		if (parent.getType().equalsIgnoreCase("directory")) {
	    	dirList.add(parent.getName());
	    } 
		for (Directory child : parent.getChilds()) {
			getAllDir(child, dirList);
        }
		return dirList;
	}
	
	
	/** Return map as key/value(dirName/Size).
	 * @param parent
	 * @param dirs
	 * @return
	 */
	public static Map<String, Long> getAllDirSizes(Directory parent, Set<String> dirs){
		
		Map<String, Long> dirInfo = new LinkedHashMap<>();
		
		for (String dirName: dirs) {
			dirInfo.put(dirName, 0l);
			getDirSizes(getDirByName(parent, dirName), dirInfo, dirName);
		}
		return dirInfo;
	}
	/** Return size of particular directory. 
	 * @param parent
	 * @return
	 */
	public static Long getDirSizes(Directory parent){
		
		return getDirSizes(parent, null, parent.getName()).get(parent.getName());
	}
	public static Map<String, Long> getDirSizes(Directory parent, Map<String, Long> dirInfo, String parentName) {

		if(dirInfo== null) dirInfo = new LinkedHashMap<>();
		
		if (parent == null) {
	    	return dirInfo;
	    }
		
		Long old = dirInfo.get(parentName);
		long newSize = parent.getSize() + (old!=null?old:0);
		
		dirInfo.put(parentName, newSize);
		
		for (Directory child : parent.getChilds()) {
			getDirSizes(child, dirInfo, parentName);
        }
		return dirInfo;
	}
	
	
	/** Get unique list of all files in tree hierarchy.
	 * @param parent
	 * @return return unique list
	 */
	public static Set<String> getAllFiles(Directory parent){
		
		return getAllFiles(parent, null);
	}
	/**Get unique list of all files in tree hierarchy. It appends in input list.
	 * @param parent
	 * @param dirList
	 * @return return unique list, It appends in input list.
	 */
	public static Set<String> getAllFiles(Directory parent, Set<String> fList) {

		if(fList== null) fList = new LinkedHashSet<>();
		
		if (parent == null) {
	    	return fList;
	    }
		if (!parent.getType().equalsIgnoreCase("directory")) {
			fList.add(parent.getName());
	    } 
		for (Directory child : parent.getChilds()) {
			getAllFiles(child, fList);
        }
		return fList;
	}

	static class Directory {
		private String name;
		private String type;
		private long size;
		private Directory parent;
		private List<Directory> childs;

		public Directory(String name, String type, long size, Directory parent) {
			this.name = name;
			this.type = type;
			this.size = size;
			this.parent = parent;
			childs = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}

		public Directory getParent() {
			return parent;
		}

		public void setParent(Directory parent) {
			this.parent = parent;
		}

		public List<Directory> getChilds() {
			return childs;
		}

		public void setChilds(List<Directory> childs) {
			this.childs = childs;
		}

		@Override
		public String toString() {
			return "Directory [name=" + name + ", type=" + type + ", size=" + size + ", childs=\n" + childs + "\n]";
		}
		
	}
}
