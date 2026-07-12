// Last updated: 7/12/2026, 11:14:13 PM
class Solution {
public:
    int fillCups(vector<int>& amount) {
        priority_queue<int> pq;

        pq.push(amount[0]);
        pq.push(amount[1]);
        pq.push(amount[2]);


        int time = 0,first = 0, second = 0;
        while(pq.top() != 0)
        {
            time++;

            if(pq.top() != 0){
                first = pq.top();
                pq.pop();
                first--;
            }

            if(pq.top() != 0){
                second = pq.top();
                pq.pop();
                second--;
            }

            pq.push(first);
            pq.push(second);
            
        }


        return time;
    }
};