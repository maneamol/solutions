import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PeerToPeer {

    /*
    chuckToUser
    1 -> 1,2,3
    user to chunk
    1 -> 1
    // leave

    // request

     */

    private Map<Integer, List<Integer>> userToChunks;
    private Map<Integer, List<Integer>> chunksToOwner;
    private int userId;
    private PriorityQueue<Integer> minUserIdHeap = new PriorityQueue<>();

    public PeerToPeer(int m) {
        // m chunks to store
        userToChunks = new HashMap<>();
        chunksToOwner = new HashMap<>();
        userId = 0;
    }

    public int join(List<Integer> ownedChunks) {
        //return minimum id
        //chuck can be owner by multiple user
        int userID = minUserIdHeap.isEmpty()? ++userId:minUserIdHeap.poll();
        for (int chunkId : ownedChunks) {
//            List<Integer> list =  chunksToOwner.getOrDefault(chunkId, new ArrayList<>());
//            list.add(userID);
//            chunksToOwner.put(chunkId, list);
            chunksToOwner.computeIfAbsent(chunkId, k -> new ArrayList<>()).add(userID);
        }

        return userID;
    }

    public void leave(int userID) {
        // free and track user id
    }

    public List<Integer> request(int userID, int chunkID) {
        // return chunk exists and owner by another user
            // list of owners sorted
            // also assigns ownership to requester if it is not owned by current user
        return null;
    }
}


