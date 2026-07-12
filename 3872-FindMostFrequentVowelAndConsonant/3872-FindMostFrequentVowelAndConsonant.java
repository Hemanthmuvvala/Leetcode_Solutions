// Last updated: 7/12/2026, 11:12:26 PM
class Solution {
    public int maxFreqSum(String s) {
        char[] word=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        int n=word.length;
        int maxVowel=0;
        int maxConsonant=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(word[i])){
                map.put(word[i],(map.get(word[i])+1));
            }
            else{
                map.put(word[i],1);
            }
        }

        for(char key:map.keySet()){
                if(key=='a'||key=='e'||key=='i'||key=='o'||key=='u'){
                    maxVowel=Math.max(maxVowel,map.get(key));
                }
                else{
                    maxConsonant=Math.max(maxConsonant,map.get(key));
                }
        }

        return maxVowel+maxConsonant;
    }
}