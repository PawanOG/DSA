class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int rows = 0;rows<numRows;rows++){
            List<Integer> row = new ArrayList<>();
            
             for (int columns = 0; columns <= rows; columns++) {

                if (columns == 0 || columns == rows) {
                    row.add(1);
                } else {
                    row.add(list.get(rows - 1).get(columns - 1)
                            + list.get(rows - 1).get(columns));
                }
            }
        list.add(row);
    
    }
    return list;
}
}