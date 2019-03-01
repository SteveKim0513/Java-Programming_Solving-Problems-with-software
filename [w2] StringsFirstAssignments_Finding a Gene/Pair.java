
/**
 * 여기에 Pair 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Pair<T> {

    private final T m_first;
    private final T m_second;
    
    public Pair(T first, T second){
        m_first = first;
        m_second = second;
    }
        
    public T first() {
        return m_first;
    }
        
    public T second() {
        return m_second;
    }
}
