package com.sankuai.inf.leaf;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.segment.model.LeafAlloc;

public interface IDGen {
    Result get(String key);
    LeafAlloc getLeafByParam(LeafAlloc leafAlloc);
    boolean init();
}
