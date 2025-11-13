

package com.psy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Головний клас програми для роботи з базою даних розкладу коледжу.
 * 
 * <p>Цей клас використовує ORM фреймворк Hibernate для взаємодії з базою даних. Він виконує дві основні операції:
 * <ul>
 *   <li>Перша транзакція: Додавання даних до таблиць Departments, Teachers, Students, Courses, Rooms, ClassSchedules та Enrollments.</li>
 *   <li>Друга транзакція: Виконання запиту для отримання інформації про розклад занять студентів.</li>
 * </ul>
 * </p>
 * 
 * <p>Клас використовує наступні Entity класи таблиць бази даних:
 * <ul>
 *   <li>{@link Psychologist}</li>
 *   <li>{@link Client}</li>
 *   <li>{@link Clinic}</li>
 *   <li>{@link Session}</li>
 * </ul>
 * </p>
 * 
 * <p>Запит у другій транзакції повертає об'єкти {@link InfoDTO}, які містять інформацію про студентів, викладачів, курси, кафедри, аудиторії, семестри, роки та час занять.</p>
 * 
 * <p>Для запуску програми необхідно мати налаштований файл конфігурації Hibernate (hibernate.cfg.xml).</p>
 * 
 * @see Psychologist
 * @see Clinic
 * @see Client
 * @see Session
 * @see InfoDTO
 */
public class MainApp {
    public static void main(String[] args) {
        // Створення фабрики сесій Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Psychologist.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Session.class)
                .addAnnotatedClass(Clinic.class)
                .buildSessionFactory();

        // Перша транзакція: Додавання даних 
        try (Session session = factory.openSession()) {

            Clinic clinic = new Clinic();
            clinic.setCity("Київ");
            clinic.setStreet("вул. Психології");
            clinic.setHouse("1");
            clinic.setPhoneNumber("380449940101");
            session.persist(clinic);

            Psychologist psy = new Psychologist();
            psy.setName("Олег Гнатюк");
            psy.setExperiece(9);
            psy.setMeetingPlatform("Zoom");
            psy.setClinic(clinic);
            session.persist(psy);

            Client client = new Client();
            client.setFirstName("Антонюк");
            client.setLastName("Іван");
            client.setPrepayment("Basic");
            client.setSessionPackage("CBT");
            client.setSessionNumber(12);
            session.persist(client);

            PSession psySession = new PSession();
            psySession.setClient(client);
            psySession.setPsychologist(psy);
            psySession.setTopic("тривога");
            psySession.setDate(LocalDate.now());
            session.persist(psySession);
            ;
                        
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Друга транзакція: Виконання запиту
        try (Session session = factory.openSession()) {
            // Початок транзакції
            session.beginTransaction();

            // Виконання запиту
            String hql = "SELECT new com.psy.InfoDTO(" +
                    "c.firstName, c.lastName, " +
                    "p.Name, p.meetingPlatform, " +
                    "prepayment, " +
                    "CONCAT(c.package, ' ', c.sessionNumber), " +
                    "s.topic," +
                    "p.expirience,"+
                    "CONCAT(cl.city, ' ', cl.street, ' ', cl.house),"+
                    "s.date" +
                    "FROM p_session s " +
                    "JOIN s.client c " +
                    "JOIN s.psychologist p " +
                    "JOIN p.clinic cl ";


            List<InfoDTO> results = session.createQuery(hql, InfoDTO.class).getResultList();

            // Обробка результатів
            for (InfoDTO info : results) {
                System.out.println("Ім'я клієнта: " + info.getClientFirstName() + " " + info.getClientFirstName());
                System.out.println("Фамілія психолога: " + info.getPsychologistName());
                System.out.println("Платформа відеозв'язку: " + info.getMeetingPlatform());
                System.out.println("Тип передплати: " + info.getPrepayment());
                System.out.println("Пакет сеансів: " + info.getSessionPackage());
                System.out.println("Тема сеансів: " + info.getTopic());
                System.out.println("Стаж психолога: " + info.getExpirience());
                System.out.println("Адреса клініки: " + info.getClinicAdress());
                System.out.println("Телефон клініки: " + info.getClinicPhoneNumber());
                System.out.println("Дата зустрічі: " + info.getDate());
                System.out.println("--------------------------------------------------");
            }

            // Підтвердження транзакції
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}