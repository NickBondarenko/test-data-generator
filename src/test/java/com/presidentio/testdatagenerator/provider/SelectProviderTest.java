/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.presidentio.testdatagenerator.provider;

import com.presidentio.testdatagenerator.cons.PropConst;
import com.presidentio.testdatagenerator.cons.TypeConst;
import com.presidentio.testdatagenerator.context.Context;
import com.presidentio.testdatagenerator.model.Field;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SelectProviderTest {

    @Test
    public void testNextValue() throws Exception {
        Map<String, String> props = new HashMap<>();
        String propItems = "5,6,7,8,9";
        String propDelimiter = ",";
        props.put(PropConst.ITEMS, propItems);
        props.put(PropConst.DELIMITER, propDelimiter);
        SelectProvider selectProvider = new SelectProvider();
        selectProvider.init(props);

        List items = Arrays.asList(propItems.split(propDelimiter));
        Object result = selectProvider.nextValue(new Context(null, null, null), new Field("testField", TypeConst.STRING, null));
        Assert.assertTrue(items.contains(result));
    }
}