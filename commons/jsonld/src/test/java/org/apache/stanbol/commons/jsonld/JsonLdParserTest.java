package org.apache.stanbol.commons.jsonld;

import static org.junit.Assert.*;

import org.junit.Test;

public class JsonLdParserTest {

    @Test
    public void testParseWithProfile() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@profile\":\"iks:employeeOf\",\"person\":{\"@iri\":\"upb:bnagel\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        
        String actual = jsonLd.toString();
        String expected = "{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":\"_:bnode1\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:bnagel\"}}";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @Test
    public void testParse3() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@profile\":\"iks:employeeOf\",\"@\":[{\"person\":{\"@iri\":\"upb:bnagel\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}},{\"person\":{\"@iri\":\"upb:fchrist\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}}]}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        jsonLd.setApplyNamespaces(false);
        
        String actual = jsonLd.toString();
        String expected = "{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":[{\"@\":\"_:bnode1\",\"@profile\":\"http:\\/\\/iks-project.eu\\/ont\\/employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"http:\\/\\/upb.de\\/persons\\/bnagel\"}},{\"@\":\"_:bnode2\",\"@profile\":\"http:\\/\\/iks-project.eu\\/ont\\/employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"http:\\/\\/upb.de\\/persons\\/fchrist\"}}]}";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @Test
    public void testParse4() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@profile\":\"iks:employeeOf\",\"@\":[{\"person\":{\"@iri\":\"upb:bnagel\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}},{\"person\":{\"@iri\":\"upb:fchrist\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}}]}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        jsonLd.setApplyNamespaces(true);
        
        String actual = jsonLd.toString();
        String expected = "{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":[{\"@\":\"_:bnode1\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:bnagel\"}},{\"@\":\"_:bnode2\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:fchrist\"}}]}";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @Test
    public void testParse5() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@profile\":\"iks:employeeOf\",\"@\":[{\"person\":{\"@iri\":\"upb:bnagel\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}},{\"person\":{\"@iri\":\"upb:fchrist\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}}]}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        jsonLd.setApplyNamespaces(true);
        jsonLd.setUseJointGraphs(false);
        
        String actual = jsonLd.toString();
        String expected = "[{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":\"_:bnode1\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:bnagel\"}},{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":\"_:bnode2\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:fchrist\"}}]";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @Test
    public void testParse6() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@\":[{\"@profile\":\"iks:employeeOf\",\"person\":{\"@iri\":\"upb:bnagel\"},\"organization\":{\"@iri\":\"http://uni-paderborn.de\"}},{\"@profile\":\"iks:friendOf\",\"person\":{\"@iri\":\"upb:bnagel\"},\"friend\":{\"@iri\":\"upb:fchrist\"}}]}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        jsonLd.setApplyNamespaces(true);
        jsonLd.setUseJointGraphs(true);
        
        String actual = jsonLd.toString();
        String expected = "{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":[{\"@\":\"_:bnode1\",\"@profile\":\"iks:employeeOf\",\"organization\":{\"@iri\":\"http:\\/\\/uni-paderborn.de\"},\"person\":{\"@iri\":\"upb:bnagel\"}},{\"@\":\"_:bnode2\",\"@profile\":\"iks:friendOf\",\"friend\":{\"@iri\":\"upb:fchrist\"},\"person\":{\"@iri\":\"upb:bnagel\"}}]}";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @Test
    public void testParse7() throws Exception {
        String jsonldInput = "{\"@context\":{\"iks\":\"http://iks-project.eu/ont/\",\"upb\":\"http://upb.de/persons/\"},\"@profile\":\"iks:employeeOf\",\"person\":\"Benjamin\",\"organization\":\"UniPaderborn\"}";
        
        JsonLd jsonLd = JsonLdParser.parse(jsonldInput);
        jsonLd.setUseTypeCoercion(true);
        jsonLd.setApplyNamespaces(true);
        jsonLd.setUseJointGraphs(true);
        
        String actual = jsonLd.toString();
        String expected = "{\"#\":{\"iks\":\"http:\\/\\/iks-project.eu\\/ont\\/\",\"upb\":\"http:\\/\\/upb.de\\/persons\\/\"},\"@\":\"_:bnode1\",\"@profile\":\"iks:employeeOf\",\"organization\":\"UniPaderborn\",\"person\":\"Benjamin\"}";
        assertEquals(expected, actual);
        assertNotNull(jsonLd);
    }
    
    @SuppressWarnings("unused")
    private void toConsole(String actual) {
        System.out.println(actual);
        String s = actual;
        s = s.replaceAll("\\\\", "\\\\\\\\");
        s = s.replace("\"", "\\\"");
        s = s.replace("\n", "\\n");
        System.out.println(s);
    }
}
