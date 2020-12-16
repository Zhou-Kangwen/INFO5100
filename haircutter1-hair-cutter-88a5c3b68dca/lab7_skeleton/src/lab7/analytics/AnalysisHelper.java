/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    //find user with most likes
    
    public void userWithMostLikes(){
        Map<Integer, Integer>userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for(User user: users.values()){
            for(Comment c: user.getComments()){
                int likes = 0;
                if(userLikesCount.containsKey(user.getId())){
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
		//dad
            }
        }
        
        int max = 0;
        int maxId = 0;
        for(int id : userLikesCount.keySet()){
            if(userLikesCount.get(id)> max){
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        
        System.out.println("User with most likes "+ max + "\n" + users.get(maxId) +"\n");
    }
    
    
    
    // find average number of likes per comments
    // TODO
    public void getAverageLikesPerCommentsComments(){
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(comments.values());
        int totalLikes = 0;
        int count = 0;
        for(Comment c: commentList){
            totalLikes += c.getLikes();
            count++;
        }
        
        System.out.println("The average number of likes per comment is:" + (totalLikes/count) +"\n");
    }
    
    // find 5 comments which have the most likes
    // TODO
    public void getTopFiveLikedComments(){
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<Comment>(comments.values());
        
        Comparator<Comment> test = new Comparator<Comment>(){
            public int compare(Comment c1, Comment c2){
                return c2.getLikes() - c1.getLikes();
            }
        };
        Collections.sort(commentList, test);
        System.out.println("Top 5 liked comments:");
        for(int i = 0; i< commentList.size() && i<5; i++){
        
        System.out.println( commentList.get(i));
        }  
        System.out.println();
        
    }
    
    //find the post with most liked comment 
    public void getPostWithMostLikedComment(){
         Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<Post>(posts.values());
        Map<Post, Integer>userPostCount = new HashMap<>();
        
        for(Post p: postList){
            for(Comment c: p.getComments()){
                int likes = 0;
                
                likes += c.getLikes();
                userPostCount.put(p, likes);
            }
        }
        
        int max = 0;
        int maxId = 0;
        for(Post p : userPostCount.keySet()){
            if(userPostCount.get(p)> max){
                max = userPostCount.get(p);
                maxId = p.getPostId();
            }
        }
        
        System.out.println("The Post ID with most liked comments is :"+ maxId +"\n"+"The total likes is :" + max +"\n");
        
    }
    
    public void getPostWithMostComments(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<Post>(posts.values());
//        for(Post p :postList){
//            System.out.println("+" +p.getPostId());
//        }
        Comparator<Post> test = new Comparator<Post>(){
            public int compare(Post p1, Post p2){
                return  p2.getComments().size() - p1.getComments().size();
            }
        };
       
        Collections.sort(postList, test);
        
        System.out.println("The ID of post with most liked comment is:"+ postList.get(0).getPostId());
        
    }
    
    public void getTopFiveInactiveUserByPost(){
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<Post>(posts.values());
        Map<Integer, Integer>userPostCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        for(User user: users.values()){
            int count = 0;
            for(Post p: postList){
                if(user.getId() == p.getUserId()) count++;
                
            }
            userPostCount.put(user.getId(), count);
        }
        
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(userPostCount.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o1.getValue() - o2.getValue();
            }        
           
        });
                
        System.out.println("The Id of Top 5 inactive Users based on total posts numbers :");
        for(int i = 0; i< list.size() && i<5; i++){
        
        System.out.println( list.get(i).getKey());
        }  
        System.out.println();
    
    }
 
 public void getTopFiveInactiveUserByComments(){
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<User>(users.values());
        
        Comparator<User> test = new Comparator<User>(){
            public int compare(User u1, User u2){
                return u1.getComments().size() - u2.getComments().size();
            }
        };
        Collections.sort(userList, test);
        System.out.println("The ID of Top 5 inactive user :");
        for(int i = 0; i< userList.size() && i<5; i++){
        
        System.out.println( userList.get(i)+ ". The total comments number is: "+ userList.get(i).getComments().size());
        }  
        System.out.println();
        
    }
 
public void getTopFiveInactiveUserByOverall(){
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<User>(users.values());
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<Post>(posts.values());
        Map<User, Integer>userTotalCount = new HashMap<>();

        for(User user: users.values()){
            int count = 0;
            int likes = 0;
            int total = 0;
            int commentsNum = user.getComments().size();
            for(Post p: postList){
                if(user.getId() == p.getUserId()) {
                    count++;
                }
            
            }
            
            for(Comment c: user.getComments()){
                likes += c.getLikes();
            }
            
            total = count + likes + commentsNum;
            
            userTotalCount.put(user, total);
        }
        
        List<Map.Entry<User,Integer>>list = new ArrayList<>(userTotalCount.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<User,Integer>>()
        {
            @Override
            public int compare(Map.Entry<User, Integer> o1, Map.Entry<User, Integer> o2)
            {
                return o1.getValue() - o2.getValue();
            }           
        });               
        System.out.println("The Id of Top 5 inactive Users overall:");
        for(int i = 0; i< list.size() && i<5; i++){
        System.out.println( list.get(i).getKey()+". The total overall number is: "+ list.get(i).getValue());
        }  
        System.out.println();
        
    }
    
     public void getTopFiveProactiveUserByOverall(){
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList = new ArrayList<User>(users.values());
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<Post>(posts.values());
        Map<User, Integer>userTotalCount = new HashMap<>();

        for(User user: users.values()){
            int count = 0;
            int likes = 0;
            int total = 0;
            int commentsNum = user.getComments().size();
            for(Post p: postList){
                if(user.getId() == p.getUserId()) {
                    count++;
                }
            
            }
            
            for(Comment c: user.getComments()){
                likes += c.getLikes();
            }
            
            total = count + likes + commentsNum;
            
            userTotalCount.put(user, total);
        }
        
        List<Map.Entry<User,Integer>>list = new ArrayList<>(userTotalCount.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<User,Integer>>()
        {
            @Override
            public int compare(Map.Entry<User, Integer> o1, Map.Entry<User, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }           
        });               
        System.out.println("The Id of Top 5 proactive Users overall:");
        for(int i = 0; i< list.size() && i<5; i++){
        System.out.println( list.get(i).getKey()+". The total overall number is: "+ list.get(i).getValue());
        }  
        System.out.println();
        
    }
}
