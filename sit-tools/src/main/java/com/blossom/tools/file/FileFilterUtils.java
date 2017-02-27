package com.blossom.tools.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @Description: 文件过滤
 * @author Blossom
 * @time 2016年12月14日 下午9:17:51
 */
public class FileFilterUtils implements FileFilter {
	
	@SuppressWarnings("rawtypes")
	private Hashtable filters = null;
    private String description = null;
    private String fullDescription = null;
    private boolean useExtensionsInDescription = true;

    @SuppressWarnings("rawtypes")
	public FileFilterUtils() {
    	this.filters = new Hashtable();
    }

    public FileFilterUtils(String extension) {
    	this(extension,null);
    }

    public FileFilterUtils(String extension, String description) {
		this();
		if(extension!=null) addExtension(extension);
	 	if(description!=null) setDescription(description);
    }

    public FileFilterUtils(String[] filters) {
    	this(filters, null);
    }

    public FileFilterUtils(String[] filters, String description) {
		this();
		for (int i = 0; i < filters.length; i++) {
		    // add filters one by one
		    addExtension(filters[i]);
		}
	 	if(description!=null) setDescription(description);
    }

    public boolean accept(File f) {
		if(f != null) {
		    if(f.isDirectory()) {
			return true;
		    }
		    String extension = getExtension(f);
		    if(extension != null && filters.get(getExtension(f)) != null) {
			return true;
		    };
		}
		return false;
    }

	public String getExtension(File f) {
		if(f != null) {
		    String filename = f.getName();
		    int i = filename.lastIndexOf('.');
		    if(i>0 && i<filename.length()-1) {
			return filename.substring(i+1).toLowerCase();
		    };
		}
		return null;
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void addExtension(String extension) {
		if(filters == null) {
		    filters = new Hashtable(5);
		}
		filters.put(extension.toLowerCase(), this);
		fullDescription = null;
    }

    @SuppressWarnings("rawtypes")
	public String getDescription() {
		if(fullDescription == null) {
		    if(description == null || isExtensionListInDescription()) {
	 		fullDescription = description==null ? "(" : description + " (";
			// build the description from the extension list
			Enumeration extensions = filters.keys();
			if(extensions != null) {
			    fullDescription += "." + (String) extensions.nextElement();
			    while (extensions.hasMoreElements()) {
				fullDescription += ", ." + (String) extensions.nextElement();
			    }
			}
			fullDescription += ")";
		    } else {
			fullDescription = description;
		    }
		}
		return fullDescription;
    }

    public void setDescription(String description) {
		this.description = description;
		fullDescription = null;
    }

    public void setExtensionListInDescription(boolean b) {
		useExtensionsInDescription = b;
		fullDescription = null;
    }

    public boolean isExtensionListInDescription() {
    	return useExtensionsInDescription;
    }
	
}
