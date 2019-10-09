package com.sankuai.inf.leaf.segment.model;

public class LeafAlloc {
    private String key;
    private long maxId;
    private int step;
    private String updateTime;
    private String appId;
    private String numSize;
    private String prefixAdd;
    private String type;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getNumSize() {
		return numSize;
	}

	public void setNumSize(String numSize) {
		this.numSize = numSize;
	}

	public String getPrefixAdd() {
		return prefixAdd;
	}

	public void setPrefixAdd(String prefixAdd) {
		this.prefixAdd = prefixAdd;
	}
    
}
