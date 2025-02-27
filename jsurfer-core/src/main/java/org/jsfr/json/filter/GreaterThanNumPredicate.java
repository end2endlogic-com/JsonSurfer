/*
 * MIT License
 *
 * Copyright (c) 2019 WANG Lingsong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.jsfr.json.filter;

import org.jsfr.json.PrimitiveHolder;
import org.jsfr.json.path.JsonPath;
import org.jsfr.json.provider.JsonProvider;

import java.math.BigDecimal;

/**
 * Created by Leo on 2017/4/4.
 */
public class GreaterThanNumPredicate extends BasicJsonPathFilter {

    private BigDecimal value;

    public GreaterThanNumPredicate(JsonPath relativePath, BigDecimal value) {
        super(relativePath);
        this.value = value;
    }

    @Override
    public boolean apply(JsonPath jsonPosition, int startDepth, PrimitiveHolder primitiveHolder, JsonProvider jsonProvider) {
        if (primitiveHolder != null && this.getRelativePath().matchFilterPath(jsonPosition, startDepth)) {
            Object candidate = primitiveHolder.getValue();
            return candidate != null && new BigDecimal(candidate.toString()).compareTo(value) > 0;
        } else {
            return false;
        }
    }

}
